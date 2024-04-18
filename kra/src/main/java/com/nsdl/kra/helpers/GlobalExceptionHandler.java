package com.nsdl.kra.helpers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nsdl.kra.exceptions.DbDataMappingException;
import com.nsdl.kra.exceptions.InvalidRequestParamException;
import com.nsdl.kra.exceptions.NoDataException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<BaseResponse<Void>> noDataAvailableException(NoDataException ex) {
        BaseResponse<Void> response = new BaseResponse<>(null, BaseResponse.ResponseStatus.FAILURE, HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidRequestParamException.class)
    public ResponseEntity<BaseResponse<Void>> invalidRequestParamException(InvalidRequestParamException ex){
        BaseResponse<Void> response = new BaseResponse<>(null, BaseResponse.ResponseStatus.FAILURE, HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DbDataMappingException.class)
    public ResponseEntity<BaseResponse<Void>> DbDataMappingException(DbDataMappingException ex){
        BaseResponse<Void> response = new BaseResponse<>(null, BaseResponse.ResponseStatus.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }


}
