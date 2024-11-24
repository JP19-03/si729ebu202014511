package org.hign.platform.u202014511.personnel.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hign.platform.u202014511.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202014511.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202014511.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Entity
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {

    @Getter
    @NotBlank
    private String firstName;

    @Getter
    @NotBlank
    private String lastName;

    @Embedded
    private NationalProviderIdentifier nationalProviderIdentifier;

    protected Examiner() {}

    public Examiner(CreateExaminerCommand command) {
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.nationalProviderIdentifier = new NationalProviderIdentifier(command.nationalProviderIdentifier());
    }

    public String getNationalProviderIdentifier() {
        return nationalProviderIdentifier.nationalProviderIdentifier();
    }
}
