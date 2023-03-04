package ru.ivanov.CustomerService.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street")
    @NotEmpty(message = "Street name should not be empty")
    private String street;

    @Column(name = "street_number")
    @NotNull(message = "Street number should not be empty")
    @Min(value = 1, message = "Street number should be positive and more then 1")
    private int streetNumber;

    @OneToOne
    @JoinColumn(name = "client", referencedColumnName = "name")
    private Client client;
}
