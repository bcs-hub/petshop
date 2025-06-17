package eu.itcrafters.petshop.persistence.pettype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PetTypeRepository extends JpaRepository<PetType, Integer> {


    @Query("select p from PetType p where upper(p.typeName) = upper(:typeName)")
    Optional<PetType> findPetTypeBy(String typeName);

}