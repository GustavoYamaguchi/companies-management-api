package com.companiesmanagementapi.companiesmanagementapi.exception;

import com.companiesmanagementapi.companiesmanagementapi.constants.Message;

public class CouldNotRetrieveSeedInformationException extends Exception {

    public CouldNotRetrieveSeedInformationException() {
        super(Message.Exception.COULD_NOT_RETRIEVE_SEED_INFORMATION);
    }
}
