package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.api.messages.DeleteCustomerCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DeleteCustomerCommandHandler implements CommandHandler<DeleteCustomerCommand, Void> {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Mono<Void> handle(DeleteCustomerCommand command) {
        kafkaTemplate.send("testTopic", "CustomerDeleted");
        return Mono.empty();
    }

    @Override
    public Class<DeleteCustomerCommand> getCommandType() {
        return DeleteCustomerCommand.class;
    }
}
