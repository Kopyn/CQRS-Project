package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.domain.CustomerAggregate;
import com.kopyn.cqrs.customer_service.command.domain.commands.CreateCustomerCommand;
import com.kopyn.cqrs.customer_service.command.domain.events.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomerCommand, Void> {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Mono<Void> handle(CreateCustomerCommand command) {
        CustomerAggregate customerAggregate = new CustomerAggregate();
        List<Event> producedEvents = customerAggregate.process(command);
        producedEvents.forEach(customerAggregate::apply);
//        log.info("Sending message to kafka");
//        CompletableFuture<SendResult<String, String>> sendResult =
//                kafkaTemplate.send("TestTopic", "CustomerCreated");

        return Mono.empty();
    }

    @Override
    public Class<CreateCustomerCommand> getCommandType() {
        return CreateCustomerCommand.class;
    }
}
