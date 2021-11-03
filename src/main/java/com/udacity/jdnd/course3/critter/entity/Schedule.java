package com.udacity.jdnd.course3.critter.entity;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;
import java.util.Set;


@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate date;

    @ElementCollection(targetClass = EmployeeSkill.class, fetch = FetchType.LAZY)
    private Set<EmployeeSkill> activities;

    @ElementCollection
    private List<Long> petIds;

    @ElementCollection
    private List<Long> employeeIds;

    @ManyToMany
    private List<Pet> pets;

    @ManyToMany
    private List<Employee> employees;

    public Schedule() {
    }

    public Schedule(long id, LocalDate date, Set<EmployeeSkill> activities) {
        this.id = id;
        this.date = date;
        this.activities = activities;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<EmployeeSkill> getActivities() {
        return activities;
    }

    public void setActivities(Set<EmployeeSkill> activities) {
        this.activities = activities;
    }
}
