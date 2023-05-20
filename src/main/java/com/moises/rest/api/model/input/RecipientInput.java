package com.moises.rest.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class RecipientInput {

    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    private String floor;

    @NotBlank
    private String city;
}
