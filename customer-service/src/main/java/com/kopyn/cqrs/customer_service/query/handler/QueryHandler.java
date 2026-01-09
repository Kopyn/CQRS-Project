package com.kopyn.cqrs.customer_service.query.handler;

import reactor.core.publisher.Mono;

public interface QueryHandler<Q, R> {

    Mono<R> handle(Q query);

}
