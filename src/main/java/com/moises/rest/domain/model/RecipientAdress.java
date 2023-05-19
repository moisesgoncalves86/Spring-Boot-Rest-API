package com.moises.rest.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class RecipientAdress {

	@Column(name = "recipient_name")
	private String name;
	
	@Column(name = "recipient_street")
	private String street;
	
	@Column(name = "recipient_number")
	private String number;
	
	@Column(name = "recipient_floor")
	private String floor;
	
	@Column(name = "recipient_city")
	private String city;
}
