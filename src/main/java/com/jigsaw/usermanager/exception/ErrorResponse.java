package com.jigsaw.usermanager.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private String errorCode;
    private String message;
    private List<String> details;

    public ErrorResponse(String message, List<String> details, String errorCode) {
        super();
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
    }

}


