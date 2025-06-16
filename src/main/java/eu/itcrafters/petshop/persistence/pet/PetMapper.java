package eu.itcrafters.petshop.persistence.pet;

import eu.itcrafters.petshop.controller.pet.dto.PetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PetMapper {

    @Mapping(source = "petType.typeName", target = "petType")
    @Mapping(source = "name", target = "petName")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "birthDate", target = "birthDate")
    PetDto toPetDto(Pet pet);

}