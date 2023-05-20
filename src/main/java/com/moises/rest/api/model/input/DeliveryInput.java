package com.moises.rest.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryInput {

    @Valid
    @NotNull
    private CustomerIdInput customer;

    @Valid
    @NotNull
    private RecipientInput recipient;

    @NotNull
    private BigDecimal deliveryFee;
}
