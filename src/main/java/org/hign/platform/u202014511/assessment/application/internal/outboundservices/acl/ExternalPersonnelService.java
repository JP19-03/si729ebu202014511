package org.hign.platform.u202014511.assessment.application.internal.outboundservices.acl;

import org.hign.platform.u202014511.personnel.interfaces.acl.PersonnelContextFacade;
import org.springframework.stereotype.Service;

@Service
public class ExternalPersonnelService {
    private final PersonnelContextFacade personnelContextFacade;

    public ExternalPersonnelService(PersonnelContextFacade personnelContextFacade) {
        this.personnelContextFacade = personnelContextFacade;
    }

    public void existsExaminer(String examinerNationalProviderIdentifier) {
        personnelContextFacade.existsExaminer(examinerNationalProviderIdentifier);
    }
}
