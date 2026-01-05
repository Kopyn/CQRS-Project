package com.kopyn.cqrs.customer_service.query.repository;

import com.kopyn.cqrs.customer_service.query.model.CustomerView;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public class CustomerViewRepository {

    private static List<CustomerView> generateCustomers() {
        CustomerView c1 = CustomerView.builder()
                .uuid(UUID.randomUUID())
                .firstName("John")
                .lastName("Rambo")
                .birthDate(LocalDate.of(1990, 1, 1))
                .documentNumber("DOC123").build();

        CustomerView c2 = CustomerView.builder()
                .uuid(UUID.randomUUID())
                .firstName("James")
                .lastName("Bond")
                .birthDate(LocalDate.of(1980, 1, 1))
                .documentNumber("DOC321").build();
        return List.of(c1, c2);
    }

    private static final List<CustomerView> customers = generateCustomers();

    public Mono<CustomerView> getCustomerById(UUID uuid) {
        return Mono.justOrEmpty(customers.stream()
                .filter(customer -> customer.getUuid().equals(uuid))
                .findAny());
    }

    public Flux<CustomerView> getAllCustomers() {
        return Flux.fromIterable(customers);
    }

}
