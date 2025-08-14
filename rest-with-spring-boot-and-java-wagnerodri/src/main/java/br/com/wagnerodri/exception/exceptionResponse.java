package br.com.wagnerodri.exception;

import java.util.Date;

public record exceptionResponse (Date timestamp , String message , String details) {

}
