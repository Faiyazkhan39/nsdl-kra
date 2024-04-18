package com.nsdl.kra.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse<T> {

    private T data;
    private ResponseStatus status;
    private int statusCode;
    private String message;

    public enum ResponseStatus {
        SUCCESS,
        FAILURE
    }

}
