package org.hign.platform.u202014511.assessment.domain.exceptions;

import java.util.Date;

public class NotValidDateException extends RuntimeException{
    public NotValidDateException(String examDate) {
        super("The date %s must not be in the past".formatted(examDate));
    }
}
