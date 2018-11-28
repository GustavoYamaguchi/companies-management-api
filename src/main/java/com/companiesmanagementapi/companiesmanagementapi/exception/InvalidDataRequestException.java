package com.companiesmanagementapi.companiesmanagementapi.exception;

import com.companiesmanagementapi.companiesmanagementapi.constants.Message;

public class InvalidDataRequestException extends Exception {

    public InvalidDataRequestException() {
        super(Message.Exception.INVALID_DATA_REQUEST);
    }
}
