package eu.itcrafters.petshop.controller.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto implements Serializable {
    private String petType;
    private String petName;
    private LocalDate birthDate;
    private BigDecimal price;
}