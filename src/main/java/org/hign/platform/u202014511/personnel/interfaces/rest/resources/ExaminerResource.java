package org.hign.platform.u202014511.personnel.interfaces.rest.resources;

public record ExaminerResource(
        Long id,
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {
}
