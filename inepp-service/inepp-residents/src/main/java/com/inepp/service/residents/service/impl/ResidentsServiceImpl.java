package com.inepp.service.residents.service.impl;

import com.inepp.common.dto.RespEnum;
import com.inepp.common.exception.security.EmptyAccountException;
import com.inepp.common.exception.security.ResidentsExistException;
import com.inepp.common.util.Encryption;
import com.inepp.domain.dao.IAccountDao;
import com.inepp.domain.dao.IResidentDao;
import com.inepp.domain.entity.Account;
import com.inepp.domain.entity.Residents;
import com.inepp.service.residents.service.IResidentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @ClassName: ResidentsServiceImpl
 * @Author
 * @Date 2022/3/27
 */
@Service
@Transactional
@Slf4j
public  class ResidentsServiceImpl implements IResidentsService {
    private IAccountDao accountDao;

    @Autowired
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private IResidentDao residentDao;

    @Autowired
    public void setResidentDao(IResidentDao residentDao) {
        this.residentDao = residentDao;
    }

    private StringRedisTemplate stringRedisTemplate ;

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @JmsListener(destination = "active.queue")
    @Override
    public void register(Residents residents) {

        if (residents==null||"".equals(residents.getPhone())) throw new EmptyAccountException(RespEnum.CHANGE_PASSWORD_SUCCESS.getMsg());

        if (Boolean.TRUE.equals(stringRedisTemplate.opsForSet().isMember("usernames", residents.getPhone()))) throw new ResidentsExistException(RespEnum.EXISTS_RESIDENTS.getMsg());

        System.out.println("消息队列"+residents);
//        residentDao.save(residents);
//        log.debug("居民注册系统成功");
//        Account account = new Account();
//        account.setRoleId(Constants.DEFAULT_ROLE);
//        account.setResidentsId(residents.getId());
//        account.setUsername(residents.getPhone());
//        account.setPassword(Encryption.getInstance().encrypt(Constants.DEFAULT_PASSWORD));
//        account.setInitPassword(Constants.IS_INIT_PASSWORD);
//        account.setCreateBy(residents.getName());
//        account.setCreateTime(new Date());
//
//        stringRedisTemplate.opsForSet().add("usernames",residents.getPhone());
//        accountDao.save(account);
//        log.debug("注册账号成功");

    }

    @Override
    public void changePassword(String userName, String password) {
        Account account = accountDao.findByUsername(userName);
        account.setPassword(Encryption.getInstance().encrypt(password));

       // accountDao.save(account);
    }

    @Override
    public void loadAllUserName() {
        String[] allUserName = accountDao.selectAllUserName();
        stringRedisTemplate.delete("usernames");
        stringRedisTemplate.opsForSet().add("usernames",allUserName);
        log.debug("缓存预热");
    }

}
