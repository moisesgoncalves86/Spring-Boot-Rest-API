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
@RequestMapping("/clients")
public class ClientController {
	
	private CustomerRepository clientRepository;
	private CrudCustomerService clientService;
	
	@GetMapping
	public List<Customer> clientList() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<Customer> getClient(@PathVariable Long clientId) {
		return clientRepository.findById(clientId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer addClient(@Valid @RequestBody Customer client) {
		return clientService.save(client);
	}
	
	@PutMapping("/{clientId}")
	public ResponseEntity<Customer> update(@Valid @PathVariable Long clientId, @RequestBody Customer client) {
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build(); 
		}
		client.setId(clientId);
		client = clientService.save(client);
		return ResponseEntity.ok(client);
	}
	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> delete(@PathVariable Long clientId) {
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		clientService.delete(clientId);
		return ResponseEntity.noContent().build();
	}

}
