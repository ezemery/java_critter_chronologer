package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("from Schedule s join s.pets p join p.owner o where o.id = :id")
    List<Schedule> findScheduleByCustomerId(@Param("id") long id);

    List<Schedule> findAllByPetsId(long id);

    List<Schedule> findAllByEmployeesId(long id);
}
