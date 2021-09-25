package com.ibm.jtcheng.sakila.exceptions;

import javax.validation.ValidationException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ibm.jtcheng.sakila.model.ApiError;

import lombok.CustomLog;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@CustomLog
public class UniformExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ValidationException.class })
	protected ResponseEntity<Object> handleValidationException(ValidationException ex,
			final ServletWebRequest request) {
		LOGGER.error("Catch a ValidationException: ", ex);

		var status = HttpStatus.BAD_REQUEST;
		var apiError = ApiError.builder().status(status.value()).error(status.getReasonPhrase())
				.path(request.getRequest().getRequestURI()).build();
		apiError.getDetails().add(ex.getLocalizedMessage());
		return buildResponseEntity(apiError, status);
	}

	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<Object> handleDefaultException(RuntimeException ex, final ServletWebRequest request) {
		LOGGER.error("Catch a RuntimeException: ", ex);

		var status = HttpStatus.INTERNAL_SERVER_ERROR;
		var apiError = ApiError.builder().status(status.value()).error(status.getReasonPhrase())
				.path(request.getRequest().getRequestURI()).build();
		return buildResponseEntity(apiError, status);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		LOGGER.error("Catch a NoHandlerFoundException: ", ex);

		var apiError = ApiError.builder().status(status.value()).error(status.getReasonPhrase())
				.path(((ServletWebRequest) request).getRequest().getRequestURI()).build();
		return buildResponseEntity(apiError, status);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LOGGER.error("Catch a MethodArgumentNotValidException: ", ex);

		var apiError = ApiError.builder().status(status.value()).error(status.getReasonPhrase())
				.path(((ServletWebRequest) request).getRequest().getRequestURI()).build();
		for (var err : ex.getAllErrors()) {
			apiError.getDetails().add(err.getDefaultMessage());
		}
		return buildResponseEntity(apiError, status);
	}

	private <T> ResponseEntity<Object> buildResponseEntity(ApiError<T> apiError, HttpStatus status) {
		return new ResponseEntity<>(apiError, status);
	}

}