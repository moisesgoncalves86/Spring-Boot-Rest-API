package com.moises.rest.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moises.rest.domain.model.Customer;
import com.moises.rest.domain.repository.CustomerRepository;
import com.moises.rest.domain.service.CrudCustomerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerRepository customerRepository;
	private CrudCustomerService customerService;
	
	@GetMapping
	public List<Customer> customerList() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId) {
		return customerRepository.findById(customerId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> update(@Valid @PathVariable Long customerId, @RequestBody Customer customer) {
		if(!customerRepository.existsById(customerId)) {
			return ResponseEntity.notFound().build(); 
		}
		customer.setId(customerId);
		customer = customerService.save(customer);
		return ResponseEntity.ok(customer);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Void> delete(@PathVariable Long customerId) {
		if(!customerRepository.existsById(customerId)) {
			return ResponseEntity.notFound().build();
		}
		customerService.delete(customerId);
		return ResponseEntity.noContent().build();
	}

}
