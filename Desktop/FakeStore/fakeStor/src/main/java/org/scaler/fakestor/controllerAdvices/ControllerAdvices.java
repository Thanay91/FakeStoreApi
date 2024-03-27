package org.scaler.fakestor.controllerAdvices;

import org.scaler.fakestor.dto.ErrorResponseDTO;
import org.scaler.fakestor.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.concurrent.TimeoutException;

@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorResponseDTO> handleArithameticException(){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage("Arithmetic Problems occurred");
        ResponseEntity responseEntity = new ResponseEntity(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        return  responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneralPointerException(){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage("Some general Error has occurred!");
        ResponseEntity responseEntity = new ResponseEntity(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        return  responseEntity;

    }

    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<ErrorResponseDTO> handleTimeOutException(){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage("Some general Error has occurred!");
        ResponseEntity responseEntity = new ResponseEntity(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        return  responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage(productNotFoundException.getMessage() + "Response generated at Global level");
        ResponseEntity responseEntity = new ResponseEntity(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        return  responseEntity;
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponseDTO> handleNullPointerException(){
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
        errorResponseDTO.setMessage("Null pointer exception");
        ResponseEntity responseEntity = new ResponseEntity(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        return  responseEntity;

    }
}
