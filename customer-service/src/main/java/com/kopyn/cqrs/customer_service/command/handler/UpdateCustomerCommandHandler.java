package com.kopyn.cqrs.customer_service.command.handler;

import com.kopyn.cqrs.customer_service.command.domain.commands.UpdateCustomerCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UpdateCustomerCommandHandler implements CommandHandler<UpdateCustomerCommand, Void> {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Mono<Void> handle(UpdateCustomerCommand command) {
        kafkaTemplate.send("testTopic", "CustomerUpdated");
        return Mono.empty();
    }

    @Override
    public Class<UpdateCustomerCommand> getCommandType() {
        return UpdateCustomerCommand.class;
    }
}
