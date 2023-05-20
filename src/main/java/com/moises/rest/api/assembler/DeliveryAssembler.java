package com.moises.rest.api.assembler;

import com.moises.rest.api.model.DeliveryDto;
import com.moises.rest.api.model.input.DeliveryInput;
import com.moises.rest.domain.model.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

    private ModelMapper modelMapper;

    public DeliveryDto toModel(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryDto.class);
    }

    public List<DeliveryDto> toCollectionsModel(List<Delivery> deliveries) {
        return deliveries.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Delivery toEntity( DeliveryInput deliveryInput) {
        return modelMapper.map(deliveryInput, Delivery.class);
    }
}
