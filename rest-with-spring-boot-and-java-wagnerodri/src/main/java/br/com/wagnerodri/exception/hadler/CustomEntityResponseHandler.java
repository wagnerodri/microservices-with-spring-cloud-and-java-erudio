package br.com.wagnerodri.exception.hadler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.wagnerodri.exception.UnsupportedMathOperationException;
import br.com.wagnerodri.exception.exceptionResponse;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<exceptionResponse> handleAllExceptions(Exception ex,WebRequest request){
		exceptionResponse reponse = new exceptionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(reponse , HttpStatus.INTERNAL_SERVER_ERROR);
	}


		@ExceptionHandler(UnsupportedMathOperationException.class)
		public final ResponseEntity<exceptionResponse> handleBadRequestExceptions(Exception ex,WebRequest request){
			exceptionResponse reponse = new exceptionResponse(
					new Date(),
					ex.getMessage(),
					request.getDescription(false));
			
			return new ResponseEntity<>(reponse , HttpStatus.BAD_REQUEST);
		}

}

