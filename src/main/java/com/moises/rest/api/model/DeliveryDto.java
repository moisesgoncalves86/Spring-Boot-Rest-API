package com.moises.rest.api.model;

import com.moises.rest.domain.model.DeliveryStatus;
import com.moises.rest.domain.model.RecipientAdress;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryDto {

    private Long id;
    private CustomerDto customer;
    private RecipientAdressDto recipient;
    private BigDecimal deliveryFee;
    private DeliveryStatus status;
    private OffsetDateTime requestDate;
    private OffsetDateTime checkoutDate;
}
