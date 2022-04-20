package com.inepp.service.residents.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.inepp.common.dto.HttpResp;
import com.inepp.common.dto.RespEnum;
import com.inepp.common.util.Encryption;
import com.inepp.domain.entity.Account;
import com.inepp.domain.entity.Residents;

import com.inepp.security.service.IAuthorityService;
import com.inepp.service.residents.service.IResidentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ResidentsController
 * @Author
 * @Date 2022/3/27
 */
@Api(tags = "居民模块")
@RestController
@RequestMapping("/api/residents")
@Slf4j
public class ResidentsController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    private IResidentsService irs;
    @Autowired
    public void setIrs(IResidentsService irs) {
        this.irs = irs;
    }

    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private IAuthorityService ias ;

    @Autowired
    public void setIas(IAuthorityService ias) {
        this.ias = ias;
    }

    @ApiOperation("居民注册")
    @PutMapping("/registry")

    public HttpResp registry(Residents residents){

//        irs.register(residents);
        jmsMessagingTemplate.convertAndSend(queue,residents);

        return  new HttpResp(RespEnum.REGISTER_SUCCESS.getCode(), RespEnum.REGISTER_SUCCESS.getMsg(), null, LocalDate.now());

    }
    @ApiOperation("修改密码，需要知道修改那个账户的密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="password",required = true),
            @ApiImplicitParam(paramType = "header",name="token",required = true)
    })
    @PostMapping("/changePassword")
    public HttpResp changePassword(String password, HttpServletRequest request,HttpServletResponse response){

        //首先根据拿到token
        String token = request.getHeader("token");
        //根据token查询是对应的account
        Account account = (Account) redisTemplate.opsForValue().get(token);
        if (account==null){
            throw new NullPointerException();
        }
        String username = account.getUsername();

        irs.changePassword(username,password);
        account.setPassword(Encryption.getInstance().encrypt(password));
        redisTemplate.opsForValue().set(token,account);
         token = JWT.create().withAudience(username).sign(Algorithm.HMAC256(password));
        response.addHeader("token",token);
        log.debug("修改密码成功");
        return new HttpResp(RespEnum.CHANGE_PASSWORD_SUCCESS.getCode(), RespEnum.CHANGE_PASSWORD_SUCCESS.getMsg(),null,LocalDate.now());

    }

    @ApiOperation( "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="userName",value = "用户名(电话号码)",dataTypeClass = String.class,example = "1234657"),
            @ApiImplicitParam(name="password",value = "密码",dataTypeClass = String.class,example = "123")
    })
    @GetMapping("/login")
    public HttpResp login(String userName, String password,  HttpServletResponse response){
        System.out.println("userName" + userName);
        Account account = ias.login(userName,password);
        System.out.println(account);
        String token = JWT.create().withAudience(userName).sign(Algorithm.HMAC256(password));
        log.debug("token: "+token);
        response.addHeader("token",token);

        redisTemplate.opsForValue().set(token,account);
        redisTemplate.expire(token,30, TimeUnit.MINUTES);

        return new HttpResp(RespEnum.LOGIN_SUCCESS.getCode(), RespEnum.LOGIN_SUCCESS.getMsg(), null,LocalDate.now());
    }

    @ApiOperation("退出登录")
    @GetMapping("/logout")
    public HttpResp logout(HttpServletRequest request){
        //首先得到token
        String token = request.getHeader("token");
        //解析处token对象中存储的username信息
        String username = JWT.decode(token).getAudience().get(0);
        //提示退出信息
        log.debug("用户"+username+"退出登录");
        //从缓存中删除这个用户
        redisTemplate.delete(token);

        log.debug("从缓存中清理失效的token...");
        return  new HttpResp(RespEnum.LOGINOUT_SUCCESS.getCode(), RespEnum.LOGINOUT_SUCCESS.getMsg(), null,LocalDate.now());
    }

}
