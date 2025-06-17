package eu.itcrafters.petshop.controller.pet.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull
    @Size(max = 50)
    private String petType;

    @NotNull
    @Size(max = 100)
    private String petName;
    private LocalDate birthDate;

    @NotNull
    private BigDecimal price;
}