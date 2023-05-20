package com.moises.rest.api.controller;

import com.moises.rest.api.assembler.DeliveryAssembler;
import com.moises.rest.api.model.DeliveryDto;
import com.moises.rest.api.model.input.DeliveryInput;
import com.moises.rest.domain.repository.DeliveryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moises.rest.domain.model.Delivery;
import com.moises.rest.domain.service.DeliveryRequestService;

import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	private DeliveryRepository deliveryRepository;
	private DeliveryRequestService deliveryRequestService;
	private DeliveryAssembler deliveryAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryDto request(@Valid @RequestBody DeliveryInput deliveryInput) {
		Delivery newDelivery = deliveryAssembler.toEntity(deliveryInput);
		Delivery requesteDelivery = deliveryRequestService.request(newDelivery);
		return deliveryAssembler.toModel(requesteDelivery);
	}

	@GetMapping
	public List<DeliveryDto> deliveryList () {
		return deliveryAssembler.toCollectionsModel(deliveryRepository.findAll());
	}

	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryDto> deliveryFind (@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
				.orElse(ResponseEntity.notFound().build());
	}
}
