package com.nw.project.common.exception;

import lombok.Data;

@Data
public class ApiException extends Exception {

    private String code;
    private String message;

    public ApiException() {
    }
    public ApiException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public ApiException(String code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
