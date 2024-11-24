package org.hign.platform.u202014511.assessment.domain.model.commands;

public record CreateMentalStateExamCommand(
        Long patientId,
        String examinerNationalProviderIdentifier,
        String examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {
}
