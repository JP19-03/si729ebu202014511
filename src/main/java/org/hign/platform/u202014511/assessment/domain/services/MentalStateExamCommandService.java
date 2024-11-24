package org.hign.platform.u202014511.assessment.domain.services;

import org.hign.platform.u202014511.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202014511.assessment.domain.model.commands.CreateMentalStateExamCommand;

import java.util.Optional;

public interface MentalStateExamCommandService {
    Optional<MentalStateExam> handle(CreateMentalStateExamCommand command);
}
