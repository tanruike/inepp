package com.inepp.domain.dao;

import com.inepp.domain.entity.GrantPrivs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: IGrantPrivs
 * @Author
 * @Date 2022/3/26
 */
@Repository
public interface IGrantPrivsDao extends JpaRepository<GrantPrivs,Integer> {
}
