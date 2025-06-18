package eu.itcrafters.petshop.service.pet;

import eu.itcrafters.petshop.controller.pet.dto.PetDto;
import eu.itcrafters.petshop.controller.pet.dto.PetInfo;
import eu.itcrafters.petshop.infrastructure.rest.error.Error;
import eu.itcrafters.petshop.infrastructure.rest.exception.DataNotFoundException;
import eu.itcrafters.petshop.persistence.pet.Pet;
import eu.itcrafters.petshop.persistence.pet.PetMapper;
import eu.itcrafters.petshop.persistence.pet.PetRepository;
import eu.itcrafters.petshop.persistence.pettype.PetType;
import eu.itcrafters.petshop.persistence.pettype.PetTypeRepository;
import eu.itcrafters.petshop.persistence.sale.Sale;
import eu.itcrafters.petshop.persistence.sale.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;
    private final PetTypeRepository petTypeRepository;
    private final SaleRepository saleRepository;

    public void addPet(PetDto petDto) {
        PetType petType = getValidPetType(petDto.getPetType());
        Pet pet = petMapper.toPet(petDto);
        pet.setPetType(petType);
        petRepository.save(pet);
    }

    public PetDto findPet(Integer petId) {
        Pet pet = getValidPet(petId);
        return petMapper.toPetDto(pet);
    }

    public List<PetInfo> findAllPets() {
        List<Pet> pets = petRepository.findAll();
        return petMapper.toPetInfos(pets);
    }

    public void updatePet(Integer petId, PetDto petDto) {
        Pet pet = getValidPet(petId);
        PetType petType = getValidPetType(petDto.getPetType());
        petMapper.updatePet(petDto, pet);
        pet.setPetType(petType);
        petRepository.save(pet);
    }

    @Transactional
    public void deletePet(Integer petId) {
        Pet pet = getValidPet(petId);
        saleRepository.findSaleBy(pet).ifPresent(sale -> saleRepository.delete(sale));
        petRepository.delete(pet);
    }

    private Pet getValidPet(Integer petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new DataNotFoundException(Error.NO_PET_EXISTS.getMessage()));
    }

    private PetType getValidPetType(String petTypeName) {
        return petTypeRepository.findPetTypeBy(petTypeName)
                .orElseThrow(() -> new DataNotFoundException(Error.NO_PET_TYPE_EXISTS.getMessage()));
    }

}
