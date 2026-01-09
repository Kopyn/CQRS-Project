package com.kopyn.cqrs.customer_service.query.api;

import java.util.UUID;

public record GetCustomerByUUIDQuery(
        UUID uuid
) implements Query {
}
