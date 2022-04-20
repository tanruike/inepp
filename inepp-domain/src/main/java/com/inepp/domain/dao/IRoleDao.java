package com.inepp.domain.dao;

import com.inepp.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: IRole
 * @Author
 * @Date 2022/3/26
 */
@Repository
public interface IRoleDao extends JpaRepository<Role,Integer> {

}
