package com.udacity.jdnd.course3.critter.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    @Nationalized
    private String name;

    @ElementCollection(targetClass = DayOfWeek.class, fetch = FetchType.LAZY)
    private Set<DayOfWeek> daysAvailable;

    @ElementCollection(targetClass = EmployeeSkill.class, fetch = FetchType.LAZY)
    private Set<EmployeeSkill> skills;

    private LocalDate date;

    public Employee() {
    }

    public Employee(long id, String name, Set<DayOfWeek> daysAvailable) {
        this.id = id;
        this.name = name;
        this.daysAvailable = daysAvailable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
