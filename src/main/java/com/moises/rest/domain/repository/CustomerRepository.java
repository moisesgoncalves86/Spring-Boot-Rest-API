package com.moises.rest.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moises.rest.domain.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{

	List<Customer> findByName(String name);
	Optional<Customer> findByEmail(String email);
}
