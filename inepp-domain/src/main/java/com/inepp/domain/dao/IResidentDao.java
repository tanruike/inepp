package com.inepp.domain.dao;

import com.inepp.domain.entity.Residents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: IResidentDao
 * @Author
 * @Date 2022/3/26
 */
@Repository
public interface IResidentDao extends JpaRepository<Residents,Integer> {
}
