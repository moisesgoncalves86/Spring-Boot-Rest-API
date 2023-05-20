package com.moises.rest.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RecipientAdressDto {

    private String name;
    private String street;
    private String number;
    private String floor;
    private String city;
}

