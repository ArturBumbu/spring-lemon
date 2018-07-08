package com.naturalprogrammer.spring.lemon.exceptions.handlers;

import java.util.Collection;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.naturalprogrammer.spring.lemon.exceptions.MultiErrorException;
import com.naturalprogrammer.spring.lemon.validation.FieldError;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class MultiErrorExceptionHandler extends AbstractExceptionHandler<MultiErrorException> {

	public MultiErrorExceptionHandler() {
		
		super(MultiErrorException.class.getSimpleName());
		log.info("Created");
	}
	
	@Override
	public String getMessage(MultiErrorException ex) {
		return ex.getMessage();
	}

	@Override
	public HttpStatus getStatus(MultiErrorException ex) {
		return ex.getStatus();
	}
	
	@Override
	public Collection<FieldError> getErrors(MultiErrorException ex) {
		return ex.getErrors();
	}
}
