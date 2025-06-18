package eu.itcrafters.petshop.persistence.sale;

import eu.itcrafters.petshop.persistence.pet.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query("select s from Sale s where s.pet = :pet")
    Optional<Sale> findSaleBy(Pet pet);

}