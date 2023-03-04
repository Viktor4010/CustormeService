package ru.ivanov.CustomerService.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "name should not be empty")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "surname should not be empty")
    private String surname;

    @Column(name = "profession")
    @NotEmpty(message = "profession should not be empty")
    private String profession;

    @Column(name = "register_at")
    @NotNull
    private LocalDateTime registerAt;

    @OneToOne(mappedBy = "client",cascade = CascadeType.PERSIST)
    private Address address;
}
