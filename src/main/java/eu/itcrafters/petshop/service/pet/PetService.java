package eu.itcrafters.petshop.service.pet;

import eu.itcrafters.petshop.infrastructure.rest.error.Error;
import eu.itcrafters.petshop.infrastructure.rest.exception.DataNotFoundException;
import eu.itcrafters.petshop.persistence.pet.Pet;
import eu.itcrafters.petshop.controller.pet.dto.PetDto;
import eu.itcrafters.petshop.persistence.pet.PetMapper;
import eu.itcrafters.petshop.persistence.pet.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetService {


    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public PetDto findPet(Integer petId) {
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new DataNotFoundException(Error.NO_PET_EXISTS.getMessage()));
        return petMapper.toPetDto(pet);
    }
}
