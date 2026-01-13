package com.kopyn.cqrs.customer_service.command.service;

import com.kopyn.cqrs.customer_service.command.api.messages.Command;
import com.kopyn.cqrs.customer_service.command.handler.CommandHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Component
public class CustomerCommandBus {

    // some kafka connector? something to send events
    Map<Class<Command>, CommandHandler<Command, Void>> handlers;

    public CustomerCommandBus(List<CommandHandler<?, ?>> handlers) {
        handlers.forEach(this::registerHandler);
    }

    public void registerHandler(CommandHandler<?, ?> handler) {

    }

    public Mono<Void> handle(Command command) {
        return handlers.get(command.getClass()).handle(command);
    }

}
