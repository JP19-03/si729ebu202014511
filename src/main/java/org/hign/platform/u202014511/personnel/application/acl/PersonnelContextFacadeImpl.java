package org.hign.platform.u202014511.personnel.application.acl;

import org.hign.platform.u202014511.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202014511.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.hign.platform.u202014511.personnel.interfaces.acl.PersonnelContextFacade;
import org.springframework.stereotype.Service;

@Service
public class PersonnelContextFacadeImpl implements PersonnelContextFacade {
    private final ExaminerRepository examinerRepository;

    public PersonnelContextFacadeImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    @Override
    public void existsExaminer(String examinerNationalProviderIdentifier) {
        if (!examinerRepository.existsByNationalProviderIdentifier(new NationalProviderIdentifier(examinerNationalProviderIdentifier))) {
            throw new IllegalArgumentException("Examiner with NPI " + examinerNationalProviderIdentifier + " does not exist");
        }
    }
}
