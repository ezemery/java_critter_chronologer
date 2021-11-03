package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("from Schedule s join fetch s.pets p" +
            " where p.owner.id = :id")
    List<Schedule> findScheduleByCustomerId(@Param("id") long id);

    @Query("from Schedule s join fetch s.pets p" +
            " where p.id = :id")
    List<Schedule> findScheduleByPet(@Param("id") long id);

    @Query("from Schedule s join fetch s.employees e" +
            " where e.id = :id")
    List<Schedule> findScheduleByEmployee(@Param("id") long id);
}
