package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.domain.CustomerAggregate;
import com.kopyn.cqrs.customer_service.command.domain.CustomerInfo;
import com.kopyn.cqrs.customer_service.command.domain.commands.DeleteCustomerCommand;
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
public class DeleteCustomerCommandHandler implements CommandHandler<DeleteCustomerCommand, CustomerInfo> {

    private final CustomerRepository customerRepository;

    @Override
    public Mono<CustomerInfo> handle(DeleteCustomerCommand command) {
        // recreate customer from events persisted in event store
        CustomerAggregate customerAggregate = customerRepository.findCustomerById(command.uuid());

        try {
            List<Event> producedEvents = customerAggregate.process();

            producedEvents.forEach(customerAggregate::apply);

            // save produced events to event store
            customerRepository.saveEvents(producedEvents);
        } catch (IllegalStateException ex) {
            log.error(ex.toString());
            return Mono.error(ex);
        }

        return Mono.just(customerAggregate.getCustomerInfo());
    }

    @Override
    public Class<DeleteCustomerCommand> getCommandType() {
        return DeleteCustomerCommand.class;
    }
}
