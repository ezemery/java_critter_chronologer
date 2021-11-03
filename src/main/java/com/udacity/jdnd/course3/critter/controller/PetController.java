package com.udacity.jdnd.course3.critter.controller;

import com.udacity.jdnd.course3.critter.dto.PetDTO;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        Pet pet = dtoToPet(petDTO);
        return petToDTO(petService.save(pet, petDTO.getOwnerId()));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        return petToDTO(petService.getPetById(petId));
    }

    @GetMapping
    public List<PetDTO> getPets(){
        List<PetDTO> dtoList = new ArrayList<>();
        List<Pet> pets =  petService.getAllPets();
        for(Pet pet : pets){
            dtoList.add(petToDTO(pet));
        }
        return dtoList;
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<PetDTO> dtoList = new ArrayList<>();
        List<Pet> pets =  petService.getPetByCustomerId(ownerId);
        for(Pet pet : pets){
            dtoList.add(petToDTO(pet));
        }
        return dtoList;
    }

    private PetDTO petToDTO(Pet pet){
        PetDTO dto = new PetDTO();
        BeanUtils.copyProperties(pet, dto);
        dto.setOwnerId(pet.getOwner().getId());
        return dto;
    }

    private Pet dtoToPet(PetDTO dto){
        Pet pet = new Pet();
        BeanUtils.copyProperties(dto, pet);
        return pet;
    }
}
