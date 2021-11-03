package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule save(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    public List<Schedule> getScheduleForPet(long id){
        return scheduleRepository.findScheduleByPet(id);
    }

    public List<Schedule> getScheduleForCustomer(long id){
        return scheduleRepository.findScheduleByCustomerId(id);
    }

    public List<Schedule> getScheduleForEmployee(long id){
        return scheduleRepository.findScheduleByEmployee(id);
    }

}
