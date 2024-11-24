package org.hign.platform.u202014511.personnel.domain.exceptions;

public class DuplicateExaminerException extends RuntimeException {
    public DuplicateExaminerException(String identifier) {
        super("Examiner with national provider identifier. %s already exists".formatted(identifier));
    }
}
