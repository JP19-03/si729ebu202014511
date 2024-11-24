package org.hign.platform.u202014511.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ExaminerNationalProviderIdentifier(String examinerNationalProviderIdentifier) {
    public ExaminerNationalProviderIdentifier(String examinerNationalProviderIdentifier) {
        this.examinerNationalProviderIdentifier = UUID.fromString(examinerNationalProviderIdentifier).toString();
    }
}
