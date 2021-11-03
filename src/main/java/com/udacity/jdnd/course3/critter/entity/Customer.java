package com.udacity.jdnd.course3.critter.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    @Nationalized
    private String name;
    private String phoneNumber;
    private String notes;
    @ElementCollection
    List<Long> petIds;



    @OneToMany(fetch=FetchType.LAZY, mappedBy = "owner")
    private List<Pet> pets;

    public Customer() {
    }

    public Customer(long id, String name, String phoneNumber, String notes) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addAPet(Pet pet){
        if(this.pets == null){
            this.pets = new ArrayList<>();
        }
        this.pets.add(pet);
    }
    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }

    public void addPetId(Long id){
        if(petIds == null){
            this.petIds = new ArrayList<>();
        }
        this.petIds.add(id);
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
