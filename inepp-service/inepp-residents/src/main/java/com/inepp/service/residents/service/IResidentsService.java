package com.inepp.service.residents.service;

import com.inepp.domain.entity.Residents;

/**
 * @ClassName: IResidentsService
 * @Author
 * @Date 2022/3/27
 */
public interface IResidentsService {
    void register(Residents residents);
    void changePassword(String userName,String password);
    void loadAllUserName();
}
