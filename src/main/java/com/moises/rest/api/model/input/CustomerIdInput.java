package com.moises.rest.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerIdInput {
    @NotNull
    private Long id;

}
