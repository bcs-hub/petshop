package eu.itcrafters.petshop.persistence.pet;

import eu.itcrafters.petshop.controller.pet.dto.PetDto;
import eu.itcrafters.petshop.controller.pet.dto.PetInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PetMapper {

    @Mapping(source = "petType.typeName", target = "petType")
    @Mapping(source = "name", target = "petName")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "birthDate", target = "birthDate")
    PetDto toPetDto(Pet pet);

    @InheritConfiguration(name = "toPetDto")
    @Mapping(source = "id", target = "petId")
    PetInfo toPetInfo(Pet pet);

    List<PetInfo> toPetInfos(List<Pet> pets);

    @Mapping(source = "petName", target = "name")
    @Mapping(source = "birthDate", target = "birthDate")
    @Mapping(source = "price", target = "price")
    @Mapping(ignore = true, target = "petType")
    Pet toPet(PetDto petDto);
}