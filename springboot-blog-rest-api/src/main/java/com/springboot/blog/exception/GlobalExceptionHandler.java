package com.springboot.blog.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.blog.payload.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> catchResouceNotFound(ResourceNotFoundException resourceNotFoundException,
			WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), resourceNotFoundException.getMessage(),
				webRequest.getDescription(false), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BlogApiException.class)
	public ResponseEntity<ErrorDetails> catchBlogApiException(BlogApiException blogApiException,
			WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), blogApiException.getMessage(),
				webRequest.getDescription(true), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> catchGlobalException(Exception exception, WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
				webRequest.getDescription(true), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}
	

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Object> catchMethodArgumentNotValidException(MethodArgumentNotValidException exception,
//			WebRequest webRequest) {
//
//		Map<String, String> errors = new HashMap<>();
//		for (Object error : exception.getBindingResult().getAllErrors()) {
//
//			String fieldName = ((FieldError) error).getField();
//			String message = ((DefaultMessageSourceResolvable) error).getDefaultMessage();
//			errors.put(fieldName, message);
//
//		}
//
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorDetails> catchResouceNotFound(AccessDeniedException accessDeniedException,
			WebRequest webRequest) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), accessDeniedException.getMessage(),
				webRequest.getDescription(false), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}

}
