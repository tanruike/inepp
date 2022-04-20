package com.inepp.domain.dao;

import com.inepp.domain.entity.Privs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: IPrivsDao
 * @Author
 * @Date 2022/3/26
 */
@Repository
public interface IPrivsDao extends JpaRepository<Privs,Integer> {
}
