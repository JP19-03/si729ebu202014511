package org.hign.platform.u202014511.personnel.interfaces.rest.resources;

public record CreateExaminerResource(
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
