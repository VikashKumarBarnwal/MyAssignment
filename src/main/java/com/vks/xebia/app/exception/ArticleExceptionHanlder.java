/**
 * 
 */
package com.vks.xebia.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Admin
 *
 */

@RestController
@ControllerAdvice
public class ArticleExceptionHanlder extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ArticleNotFoundException.class)
	public  ResponseEntity<Object> handleArticleNotFoundException(Exception ex, WebRequest request) throws Exception {
	  ExceptionResponse  exceptionResponse = new ExceptionResponse(ex.getMessage(), new Date(), request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}

}
