package com.kopyn.cqrs.customer_service.query.query_bus;

import com.kopyn.cqrs.customer_service.query.handler.QueryHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerQueryBus {

    private final Map<Class<?>, QueryHandler<?, ?>> handlers = new HashMap<>();

    public <Q, R> void registerHandler(Class<Q> queryType, QueryHandler<Q, R> handler) {
        handlers.put(queryType, handler);
    }

    @SuppressWarnings("unchecked")
    public <Q, R> Mono<R> dispatch(Q query) {
        QueryHandler<Q, R> handler = (QueryHandler<Q, R>) handlers.get(query.getClass());

        if (handler == null) {
            return Mono.error(new IllegalStateException("No handler for query: " + query.getClass()));
        }

        return handler.handle(query);
    }

}
