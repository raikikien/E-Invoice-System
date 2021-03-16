package com.project.user;

import org.springframework.http.HttpStatus;

public enum CustomError {
    NO_CONTENT(1, HttpStatus.NO_CONTENT)
    ;
    private int code;
    private HttpStatus status;

    CustomError(int code, HttpStatus status) {

    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
