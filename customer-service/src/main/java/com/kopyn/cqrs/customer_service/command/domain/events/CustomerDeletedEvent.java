package com.kopyn.cqrs.customer_service.command.domain.events;

import com.kopyn.cqrs.customer_service.command.domain.CustomerInfo;

import java.util.UUID;

public record CustomerDeletedEvent(
        CustomerInfo customerInfo,
        int customerVersion
) implements Event {
    @Override
    public String getAggregateId() {
        return customerInfo.getUuid();
    }

    @Override
    public int getAggregateVersion() {
        return customerVersion;
    }
}
