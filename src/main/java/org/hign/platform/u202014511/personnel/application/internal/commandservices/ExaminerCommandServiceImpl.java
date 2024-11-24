package org.hign.platform.u202014511.personnel.application.internal.commandservices;

import org.hign.platform.u202014511.personnel.domain.exceptions.DuplicateExaminerException;
import org.hign.platform.u202014511.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202014511.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202014511.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202014511.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u202014511.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {
    private final ExaminerRepository examinerRepository;

    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        if (examinerRepository.existsByNationalProviderIdentifier(new NationalProviderIdentifier(command.nationalProviderIdentifier()))) {
            throw new DuplicateExaminerException(command.nationalProviderIdentifier());
        }
        var examiner = new Examiner(command);
        examinerRepository.save(examiner);
        return Optional.of(examiner);
    }
}
