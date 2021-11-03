package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Schedules.
 */

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
       Schedule schedule = dtoToSchedule(scheduleDTO);
       return scheduleToDTO( scheduleService.save(schedule));
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<ScheduleDTO> dtoList = new ArrayList<>();
        List<Schedule> schedules = scheduleService.getAllSchedules();

        for(Schedule schedule : schedules){
            dtoList.add(scheduleToDTO(schedule));
        }
        return dtoList;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<ScheduleDTO> dtoList = new ArrayList<>();
        List<Schedule> petSchedules= scheduleService.getScheduleForPet(petId);
        for(Schedule schedule : petSchedules){
            dtoList.add(scheduleToDTO(schedule));
        }
        return dtoList;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<ScheduleDTO> dtoList = new ArrayList<>();
        List<Schedule> employeeSchedules = scheduleService.getScheduleForEmployee(employeeId);
        for(Schedule schedule : employeeSchedules){
            dtoList.add(scheduleToDTO(schedule));
        }
        return dtoList;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<ScheduleDTO> dtoList = new ArrayList<>();
        List<Schedule> customerSchedules = scheduleService.getScheduleForCustomer(customerId);
        for(Schedule schedule : customerSchedules){
            dtoList.add(scheduleToDTO(schedule));
        }
        return dtoList;
    }

    private ScheduleDTO scheduleToDTO(Schedule schedule){
        ScheduleDTO dto = new ScheduleDTO();
        BeanUtils.copyProperties(schedule, dto);
        return dto;
    }

    private Schedule dtoToSchedule(ScheduleDTO dto){
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(dto, schedule);
        return schedule;
    }
}
