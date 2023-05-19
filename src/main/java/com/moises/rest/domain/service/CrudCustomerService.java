package com.moises.rest.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moises.rest.domain.exception.BusinessException;
import com.moises.rest.domain.model.Customer;
import com.moises.rest.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CrudCustomerService {

	private CustomerRepository customerRepository;
	
	public Customer findCustomer(Long customerId) {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new BusinessException("Customer not found"));
	}
	
	@Transactional
	public Customer save(Customer customer){
		
		boolean usedEmail = customerRepository.findByEmail(customer.getEmail())
				.stream()
				.anyMatch(existingCustomer -> !existingCustomer.equals(customer));
		
		if(usedEmail) {
			throw new BusinessException("This email is already registered.");
		}
		
		return customerRepository.save(customer);
	}
	
	@Transactional
	public void delete(Long clientId) {
		customerRepository.deleteById(clientId);
	}
}
