package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.domain.CustomerAggregate;
import com.kopyn.cqrs.customer_service.command.domain.CustomerInfo;
import com.kopyn.cqrs.customer_service.command.domain.commands.DeleteCustomerCommand;
import com.kopyn.cqrs.customer_service.command.domain.events.Event;
import com.kopyn.cqrs.customer_service.command.repository.CustomerQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DeleteCustomerCommandHandler implements CommandHandler<DeleteCustomerCommand, CustomerInfo> {

    private final CustomerQueryRepository customerQueryRepository;

    @Override
    public Mono<CustomerInfo> handle(DeleteCustomerCommand command) {
        // recreate customer from events persisted in event store
        CustomerAggregate customerAggregate = customerQueryRepository.findCustomerById(command.uuid());

        // process incoming command
        List<Event> producedEvents = customerAggregate.process(command);

        producedEvents.forEach(customerAggregate::apply);

        // apply and save events
        customerQueryRepository.saveEvents(producedEvents);
        return Mono.just(customerAggregate.getCustomerInfo());
    }

    @Override
    public Class<DeleteCustomerCommand> getCommandType() {
        return DeleteCustomerCommand.class;
    }
}
