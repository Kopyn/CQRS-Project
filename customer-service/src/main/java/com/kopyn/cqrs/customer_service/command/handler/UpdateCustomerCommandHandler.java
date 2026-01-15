package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.domain.CustomerAggregate;
import com.kopyn.cqrs.customer_service.command.domain.CustomerInfo;
import com.kopyn.cqrs.customer_service.command.domain.commands.UpdateCustomerCommand;
import com.kopyn.cqrs.customer_service.command.domain.events.Event;
import com.kopyn.cqrs.customer_service.command.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpdateCustomerCommandHandler implements CommandHandler<UpdateCustomerCommand, CustomerInfo> {

    private final CustomerRepository customerRepository;

    @Override
    public Mono<CustomerInfo> handle(UpdateCustomerCommand command) {
        // find customer in repository and replay its state
        CustomerAggregate customerAggregate = customerRepository.findCustomerById(command.uuid());

        // process incoming command
        List<Event> producedEvents = customerAggregate.process(command);

        producedEvents.forEach(customerAggregate::apply);

        // save produced events to event store
        customerRepository.saveEvents(producedEvents);

        return Mono.just(customerAggregate.getCustomerInfo());
    }

    @Override
    public Class<UpdateCustomerCommand> getCommandType() {
        return UpdateCustomerCommand.class;
    }
}
