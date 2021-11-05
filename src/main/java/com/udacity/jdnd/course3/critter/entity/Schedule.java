package com.udacity.jdnd.course3.critter.entity;

import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;
import java.util.Set;


@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private LocalDate date;

    @ElementCollection(targetClass = EmployeeSkill.class, fetch = FetchType.LAZY)
    private Set<EmployeeSkill> activities;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SCHEDULE_PET", joinColumns = @JoinColumn(name = "SCHEDULE_ID"), inverseJoinColumns = @JoinColumn(name = "PET_ID"))
    private List<Pet> pets;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "SCHEDULE_EMPLOYEE", joinColumns = @JoinColumn(name = "SCHEDULE_ID"), inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
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
