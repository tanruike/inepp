package com.inepp.security.service.interceptor;

import com.auth0.jwt.JWT;
import com.inepp.common.dto.RespEnum;
import com.inepp.common.exception.security.HasNotLoginException;
import com.inepp.common.exception.security.HostAuthorizedException;
import com.inepp.domain.entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
  @ClassName: AuthorityInterpetor
 * @Author
 * @Date 2022/3/28
 */

/**
 * 拦截请求
 */
public class AuthorityInterceptor implements HandlerInterceptor {

    private RedisTemplate<String,Object> redisTemplate; // 缓存
    private StringRedisTemplate stringRedisTemplate; //缓存对象

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 拦截处理
     * @param request current HTTP request
     * @param response current HTTP response
     * @param handler chosen handler to execute, for type and/or instance evaluation
     * @return
     * @throws Exception 异常处理
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //首先得到token
        String token = request.getHeader("token");

        System.out.println("token的长度"+token.length());


        System.out.println("拦截处理"+token);
        if (token==null||"".equals(token)||token.split("\\.").length!=3||token.length()!=99) throw  new HasNotLoginException(RespEnum.NOT_LOGIN.getMsg());

        //得到用户名
        String username = JWT.decode(token).getAudience().get(0);
        //根据token得到账号信息
        Account account = (Account) redisTemplate.opsForValue().get(token);
        //如果没有这个用户
        if (account==null){
            throw new HasNotLoginException(RespEnum.NOT_LOGIN.getMsg());
        }

        if (!username.equals(account.getUsername())){
            throw new HasNotLoginException(RespEnum.NOT_LOGIN.getMsg());
        }
        String key ="role_"+ account.getRoleId();

       HandlerMethod hm =(HandlerMethod) handler;

        if (!stringRedisTemplate.opsForSet().isMember(key,hm.getMethod().getName())){
            throw new HostAuthorizedException(RespEnum.HOST_UNAUTHORIZED.getMsg());
        }

        //登录成功 检查权限
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
