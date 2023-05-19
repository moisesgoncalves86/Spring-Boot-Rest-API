package com.moises.rest.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moises.rest.domain.model.Delivery;
import com.moises.rest.domain.service.DeliveryRequestService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	private DeliveryRequestService deliveryRequestService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery request(@RequestBody Delivery delivery) {
		return deliveryRequestService.request(delivery);
	}
}
