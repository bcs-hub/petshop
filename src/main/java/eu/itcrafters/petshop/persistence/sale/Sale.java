package eu.itcrafters.petshop.persistence.sale;

import eu.itcrafters.petshop.persistence.customer.Customer;
import eu.itcrafters.petshop.persistence.pet.Pet;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "SALE")
public class Sale {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PET_ID", nullable = false)
    private Pet pet;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @NotNull
    @Column(name = "SALE_DATE", nullable = false)
    private LocalDate saleDate;

    @NotNull
    @Column(name = "SALE_PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal salePrice;

}