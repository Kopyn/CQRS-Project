package com.kopyn.cqrs.customer_service.command.domain;


import com.kopyn.cqrs.customer_service.command.domain.commands.CreateCustomerCommand;
import com.kopyn.cqrs.customer_service.command.domain.commands.DeleteCustomerCommand;
import com.kopyn.cqrs.customer_service.command.domain.commands.UpdateCustomerCommand;
import com.kopyn.cqrs.customer_service.command.domain.events.CustomerCreatedEvent;
import com.kopyn.cqrs.customer_service.command.domain.events.CustomerDeletedEvent;
import com.kopyn.cqrs.customer_service.command.domain.events.CustomerUpdatedEvent;
import com.kopyn.cqrs.customer_service.command.domain.events.Event;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
public class CustomerAggregate {
    private UUID uuid;
    private int version = -1;
    private CustomerInfo customerInfo;

    List<Event> changes = new ArrayList<>();

    public List<Event> process(CreateCustomerCommand createCustomerCommand) {
        Event customerCreatedEvent = new CustomerCreatedEvent(createCustomerCommand.uuid(),
                createCustomerCommand.customerInfo());
        changes.add(customerCreatedEvent);
        return List.of(customerCreatedEvent);
    }

    public List<Event> process(UpdateCustomerCommand updateCustomerCommand) {
        Event customerUpdatedEvent = new CustomerUpdatedEvent(updateCustomerCommand.customerInfo());
        changes.add(customerUpdatedEvent);
        return List.of(customerUpdatedEvent);
    }

    public List<Event> process(DeleteCustomerCommand deleteCustomerCommand) {
        if (customerInfo.isDeleted()) {
            throw new IllegalStateException("Customer is already deleted");
        }
        Event customerDeletedEvent = new CustomerDeletedEvent();
        changes.add(customerDeletedEvent);
        return List.of(customerDeletedEvent);
    }

    public void apply(Event event) {
        if (event instanceof CustomerCreatedEvent e) {
            apply(e);
        } else if (event instanceof CustomerUpdatedEvent e) {
            apply(e);
        } else if (event instanceof CustomerDeletedEvent e) {
            apply(e);
        } else {
            throw new IllegalArgumentException("Unknown event type: " + event);
        }
    }



    public CustomerInfo apply(CustomerCreatedEvent event) {
        uuid = event.uuid();
        customerInfo = new CustomerInfo(event.customerInfo());
        version += 1;
        return this.customerInfo;
    }

    public CustomerInfo apply(CustomerUpdatedEvent event) {
        customerInfo = new CustomerInfo(event.customerInfo());
        version += 1;
        return this.customerInfo;
    }

    public CustomerInfo apply(CustomerDeletedEvent event) {
        version += 1;
        customerInfo.setDeleted(true);
        return this.customerInfo;
    }
}
