package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.exception.NotFoundException;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetService {
    @Autowired
    private PetRepository petsRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Pet save(Pet pet, long id){
        Customer customer = customerRepository.getOne(id);
        pet.setOwner(customer);
        Pet p = petsRepository.save(pet);
        Customer c = p.getOwner();
        c.addAPet(p);
        c.addPetId(p.getId());
        return  p;
    }

    public List<Pet> getPetByCustomerId(long ownerId){
        return petsRepository.findPetByCustomerId(ownerId);
    }

    public List<Pet> getAllPets(){
        return petsRepository.findAll();
    }

    public Pet getPetById(long petId){
        Optional<Pet> optionalPet = petsRepository.findById(petId);
        if (optionalPet.isPresent()) {
           return optionalPet.get();
        } else {
            throw new NotFoundException("Unable to find pet with id: "+ petId);
        }
    }
}
