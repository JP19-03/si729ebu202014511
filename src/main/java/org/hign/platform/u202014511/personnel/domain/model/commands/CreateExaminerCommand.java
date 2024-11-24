package org.hign.platform.u202014511.personnel.domain.model.commands;

public record CreateExaminerCommand(
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
