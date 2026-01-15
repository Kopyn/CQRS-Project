package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.domain.CustomerAggregate;
import com.kopyn.cqrs.customer_service.command.domain.CustomerInfo;
import com.kopyn.cqrs.customer_service.command.domain.commands.CreateCustomerCommand;
import com.kopyn.cqrs.customer_service.command.domain.events.Event;
import com.kopyn.cqrs.customer_service.command.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomerCommand, CustomerInfo> {

    private final CustomerRepository customerRepository;

    @Override
    public Mono<CustomerInfo> handle(CreateCustomerCommand command) {
        // create fresh aggregate
        CustomerAggregate customerAggregate = new CustomerAggregate();

        // process command - it returns list of produced events
        List<Event> producedEvents = customerAggregate.process(command);

        // apply events to return updated entity via API
        producedEvents.forEach(customerAggregate::apply);

        // save produced events to the event store, you can apply them if you want to return the entity that
        // your command was changing
        customerRepository.saveEvents(producedEvents);

        // change implementation so saveEvents returns a Mono when it's finished and return it in this method
        return Mono.just(customerAggregate.getCustomerInfo());
    }

    @Override
    public Class<CreateCustomerCommand> getCommandType() {
        return CreateCustomerCommand.class;
    }
}
