package com.moises.rest.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moises.rest.domain.model.Customer;
import com.moises.rest.domain.model.Delivery;
import com.moises.rest.domain.model.DeliveryStatus;
import com.moises.rest.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryRequestService {

	private CrudCustomerService customerService;
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public Delivery request(Delivery delivery) {
		Customer customer = customerService.findCustomer(delivery.getCustomer().getId());
		
		
		delivery.setCustomer(customer);
		delivery.setStatus(DeliveryStatus.PENDING);
		delivery.setRequestDate(LocalDateTime.now());
		
		return deliveryRepository.save(delivery);
	}
	
}
