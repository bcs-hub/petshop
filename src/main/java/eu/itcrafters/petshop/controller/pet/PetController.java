package eu.itcrafters.petshop.controller.pet;

import eu.itcrafters.petshop.controller.pet.dto.PetInfo;
import eu.itcrafters.petshop.infrastructure.rest.error.ApiError;
import eu.itcrafters.petshop.controller.pet.dto.PetDto;
import eu.itcrafters.petshop.service.pet.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping("/pet/{petId}")
    @Operation(summary = "Finds a pet by its ID", description = "Finds a pet by its ID, if no match is found then error is thrown")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Pet does not exist",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
    })
    public PetDto findPet(@PathVariable Integer petId) {
        return petService.findPet(petId);
    }

    @GetMapping("/pets")
    @Operation(summary = "Finds all pets")
    public List<PetInfo> findAllPets() {
        return petService.findAllPets();
    }
}
