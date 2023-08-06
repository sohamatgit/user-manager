package com.jigsaw.usermanager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserManagerException extends RuntimeException {
    private String errorCode;
    private String message;
}

