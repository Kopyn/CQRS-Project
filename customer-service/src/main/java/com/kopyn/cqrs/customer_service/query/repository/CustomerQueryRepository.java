package com.kopyn.cqrs.customer_service.query.repository;

import com.kopyn.cqrs.customer_service.domain.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class CustomerQueryRepository {

    private static final List<Customer> customers = generateCustomers();

    private static List<Customer> generateCustomers() {
        Customer c1 = Customer.builder()
                .uuid(UUID.randomUUID())
                .firstName("John")
                .lastName("Rambo")
                .birthDate(LocalDate.of(1990, 1, 1))
                .documentNumber("ABC123")
                .build();

        Customer c2 = Customer.builder()
                .uuid(UUID.randomUUID())
                .firstName("Jason")
                .lastName("Bourne")
                .birthDate(LocalDate.of(1980, 12, 1))
                .documentNumber("XYZ323")
                .build();

        return List.of(c1, c2);
    }

    public Mono<Customer> getCustomerById(UUID uuid) {
        return Mono.justOrEmpty(customers.stream()
                .filter(customer -> customer.getUuid().equals(uuid)).findAny());
    }

    public Flux<Customer> getAllCustomers() {
        return Flux.fromIterable(customers);
    }
}
