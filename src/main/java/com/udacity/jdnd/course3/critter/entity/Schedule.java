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
