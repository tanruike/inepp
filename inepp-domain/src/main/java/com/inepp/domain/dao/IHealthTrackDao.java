package com.inepp.domain.dao;

import com.inepp.domain.entity.HealthTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: IHealthTrackDao
 * @Author
 * @Date 2022/3/26
 */
@Repository
public interface IHealthTrackDao extends JpaRepository<HealthTrack,Integer> {
}
