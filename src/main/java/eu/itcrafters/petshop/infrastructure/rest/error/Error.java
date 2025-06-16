package eu.itcrafters.petshop.infrastructure.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {
    NO_PET_EXISTS("Pet does not exit");

    private final String message;
}
