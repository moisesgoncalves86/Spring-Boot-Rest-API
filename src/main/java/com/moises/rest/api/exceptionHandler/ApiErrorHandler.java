package com.moises.rest.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Data
class ApiErrorHandler {

	private Integer status;
	private LocalDateTime dateHourDate;
	private String message;
	private List<Field> fields;
	
	@AllArgsConstructor
	@Getter
	public static class Field {
		
		private String name;
		private String message;
			
		
	}
}
