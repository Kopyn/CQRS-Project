package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.api.messages.CreateCustomerCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomerCommand, Void> {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Mono<Void> handle(CreateCustomerCommand command) {
        log.info("Sending message to kafka");
        CompletableFuture<SendResult<String, String>> sendResult =
                kafkaTemplate.send("TestTopic", "CustomerCreated");

        return Mono.empty();
    }

    @Override
    public Class<CreateCustomerCommand> getCommandType() {
        return CreateCustomerCommand.class;
    }
}
