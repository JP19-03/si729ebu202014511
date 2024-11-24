package org.hign.platform.u202014511.assessment.application.internal.commandservices;

import org.hign.platform.u202014511.assessment.application.internal.outboundservices.acl.ExternalPersonnelService;
import org.hign.platform.u202014511.assessment.domain.exceptions.NotValidDateException;
import org.hign.platform.u202014511.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202014511.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202014511.assessment.domain.services.MentalStateExamCommandService;
import org.hign.platform.u202014511.assessment.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {
    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExternalPersonnelService externalPersonnelService;

    public MentalStateExamCommandServiceImpl(MentalStateExamRepository mentalStateExamRepository, ExternalPersonnelService externalPersonnelService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.externalPersonnelService = externalPersonnelService;
    }

    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateExamCommand command) {
        externalPersonnelService.existsExaminer(command.examinerNationalProviderIdentifier());

        var examDate = parseExamDate(command.examDate());
        if (examDate.before(new Date())) {
            throw new NotValidDateException(command.examDate());
        }

        var mentalStateExam = new MentalStateExam(command, examDate);
        mentalStateExamRepository.save(mentalStateExam);
        return Optional.of(mentalStateExam);
    }

    private Date parseExamDate(String examDateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(examDateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("The format of the exam date is invalid. It should be in the format yyyy-MM-dd.");
        }
    }
}
