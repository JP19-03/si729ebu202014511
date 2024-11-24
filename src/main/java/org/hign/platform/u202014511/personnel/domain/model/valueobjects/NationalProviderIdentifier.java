package org.hign.platform.u202014511.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record NationalProviderIdentifier(String nationalProviderIdentifier) {
    public NationalProviderIdentifier(String nationalProviderIdentifier) {
        this.nationalProviderIdentifier = UUID.fromString(nationalProviderIdentifier).toString();
    }
}
