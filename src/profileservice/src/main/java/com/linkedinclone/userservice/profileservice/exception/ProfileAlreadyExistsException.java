package com.linkedinclone.userservice.profileservice.exception;

public class ProfileAlreadyExistsException extends RuntimeException {

    public ProfileAlreadyExistsException(String message) {
        super(message);
    }

}
