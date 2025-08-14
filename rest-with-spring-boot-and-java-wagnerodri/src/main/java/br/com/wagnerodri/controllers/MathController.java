package br.com.wagnerodri.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wagnerodri.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {
	
	// http://localhost:8080/math/sum/3/5
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public double sum(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
			
			) throws Exception {
		
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) 
			throw new UnsupportedMathOperationException("Please set a numeric value");
		return convertToDouble(numberOne) + convertToDouble (numberTwo);
	}

	private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty()) 
        	throw new UnsupportedMathOperationException("Please set a numeric value");
		String number = strNumber.replace(",", "."); // R$ 5,00 USD 5.0
	    return  Double.parseDouble(number);
		
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null || strNumber.isEmpty()) return false;
		
	    String number = strNumber.replace(",", "."); // R$ 5,00 USD 5.0
	    return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	

	// http://localhost:8080/math/subtraction/10/5
	@RequestMapping("/subtraction/{numberOne}/{numberTwo}")
	public double subtraction(
	        @PathVariable("numberOne") String numberOne,
	        @PathVariable("numberTwo") String numberTwo
	) throws Exception {
	    
	    if (!isNumeric(numberOne) || !isNumeric(numberTwo)) 
	        throw new UnsupportedMathOperationException("Please set a numeric value");
	    
	    return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	// http://localhost:8080/multi/sum/3/5
	@RequestMapping ("/multi/{numberOne}/{numberTwo}")
	public double multi(
			@PathVariable("numberOne") String numberOne,
	        @PathVariable("numberTwo") String numberTwo
			) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value");
		
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	

	// http://localhost:8080/division/sum/3/5
	@RequestMapping ("/division/{numberOne}/{numberTwo}")
	public double division(
			@PathVariable("numberOne") String numberOne,
	        @PathVariable("numberTwo") String numberTwo
			) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value");
		
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	// http://localhost:8080/math/media/3/5
	@RequestMapping("/media/{numberOne}/{numberTwo}")
	public double media(
	        @PathVariable("numberOne") String numberOne,
	        @PathVariable("numberTwo") String numberTwo
	) throws Exception {
	    
	    if (!isNumeric(numberOne) || !isNumeric(numberTwo))
	        throw new UnsupportedMathOperationException("Please set a numeric value");
	    
	    return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
	}
	
	// http://localhost:8080/math/squareRoot/16
	@RequestMapping("/squareRoot/{number}")
	public double squareRoot(
	        @PathVariable("number") String number
	) throws Exception {

	    if (!isNumeric(number))
	        throw new UnsupportedMathOperationException("Please set a numeric value");

	    return Math.sqrt(convertToDouble(number));
	}


	
}
