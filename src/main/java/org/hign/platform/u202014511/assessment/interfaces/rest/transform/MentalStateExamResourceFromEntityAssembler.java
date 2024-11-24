package org.hign.platform.u202014511.assessment.interfaces.rest.transform;

import org.hign.platform.u202014511.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202014511.assessment.interfaces.rest.resources.MentalStateExamResource;

public class MentalStateExamResourceFromEntityAssembler {
    public static MentalStateExamResource toResourceFromEntity(MentalStateExam entity) {
        return new MentalStateExamResource(
                entity.getId(),
                entity.getPatientId(),
                entity.getExaminerNationalProviderIdentifier(),
                entity.getExamDate(),
                entity.getOrientationScore(),
                entity.getRegistrationScore(),
                entity.getAttentionAndCalculationScore(),
                entity.getRecallScore(),
                entity.getLanguageScore()
        );
    }
}
