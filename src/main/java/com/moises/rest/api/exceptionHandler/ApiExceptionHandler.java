package com.moises.rest.api.exceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.moises.rest.domain.exception.BusinessException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ApiErrorHandler.Field> fields = new ArrayList<>();
		
		for(ObjectError error: ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());		
			
			fields.add(new ApiErrorHandler.Field(name, message));
		}
		
		ApiErrorHandler errorHandler = new ApiErrorHandler();
		errorHandler.setStatus(status.value());
		errorHandler.setDateHourDate(LocalDateTime.now());
		errorHandler.setMessage("One or more fields are invalid. Fill it out correctly and try again.");
		errorHandler.setFields(fields);
		
		return handleExceptionInternal(ex, errorHandler, headers, status, request);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> businessHandle(BusinessException ex, WebRequest request) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		ApiErrorHandler errorHandler = new ApiErrorHandler();
		errorHandler.setStatus(status.value());
		errorHandler.setDateHourDate(LocalDateTime.now());
		errorHandler.setMessage(ex.getMessage());
		
		return handleExceptionInternal(ex, errorHandler, new HttpHeaders(), status, request);
	}
}
