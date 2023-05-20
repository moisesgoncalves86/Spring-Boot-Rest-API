package com.moises.rest.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class RecipientAdress {

	@NotBlank
	@Column(name = "recipient_name")
	private String name;

	@NotBlank
	@Column(name = "recipient_street")
	private String street;

	@NotBlank
	@Column(name = "recipient_number")
	private String number;


	@Column(name = "recipient_floor")
	private String floor;

	@NotBlank
	@Column(name = "recipient_city")
	private String city;
}
