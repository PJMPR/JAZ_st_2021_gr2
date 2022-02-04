package com.prSecurity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CustomerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private String email;

    public CustomerDto(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public CustomerDto(long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
