package com.inepp.domain.dao;

import com.inepp.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: IAccountDao
 * @Author
 * @Date 2022/3/26
 */
@Repository
public interface IAccountDao extends JpaRepository<Account,Integer> {
    Account findByUsername(String userName);
    @Query(value = "SELECT account_username FROM account_tab" ,nativeQuery = true)
    String[] selectAllUserName();
}
