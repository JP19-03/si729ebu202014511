package org.hign.platform.u202014511.assessment.interfaces.rest.resources;

import java.util.Date;

public record MentalStateExamResource(
        Long id,
        Long patientId,
        String examinerNationalProviderIdentifier,
        Date examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {
}
