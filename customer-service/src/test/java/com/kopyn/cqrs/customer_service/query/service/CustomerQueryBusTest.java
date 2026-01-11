package com.kopyn.cqrs.customer_service.query.service;

import com.kopyn.cqrs.customer_service.domain.Customer;
import com.kopyn.cqrs.customer_service.query.api.GetAllCustomersQuery;
import com.kopyn.cqrs.customer_service.query.api.GetCustomerByUUIDQuery;
import com.kopyn.cqrs.customer_service.query.handler.GetAllCustomersHandler;
import com.kopyn.cqrs.customer_service.query.handler.GetCustomerByUUIDHandler;
import com.kopyn.cqrs.customer_service.query.handler.QueryHandler;
import com.kopyn.cqrs.customer_service.query.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

class CustomerQueryBusTest {

    private static CustomerRepository repositoryMock;

    @BeforeAll
    static void setUp() {
        repositoryMock = Mockito.mock(CustomerRepository.class);
    }

    @Test
    void handleGetAllCustomersQuery() {
        // Given
        Customer customer1 = Customer.builder()
                .uuid(UUID.randomUUID())
                .firstName("John")
                .lastName("Rambo")
                .birthDate(LocalDate.of(1990, 1, 1))
                .documentNumber("ABC123")
                .build();

        Customer customer2 = Customer.builder()
                .uuid(UUID.randomUUID())
                .firstName("Jason")
                .lastName("Bourne")
                .birthDate(LocalDate.of(1980, 12, 1))
                .documentNumber("XYZ323")
                .build();
        Flux<Customer> customerFlux = Flux.just(customer1, customer2);
        Mockito.when(repositoryMock.getAllCustomers()).thenReturn(customerFlux);
        QueryHandler<GetAllCustomersQuery, Customer> getAllCustomersHandlerMock =
                new GetAllCustomersHandler(repositoryMock);

        // When
        CustomerQueryBus queryBus = new CustomerQueryBus(List.of(getAllCustomersHandlerMock));

        // Then
        StepVerifier.create(queryBus.handleQuery(new GetAllCustomersQuery()))
                .expectNext(customer1)
                .expectNext(customer2)
                .expectComplete()
                .verify();
    }

    @Test
    void handleGetCustomerByUUIDQuery() {
        // Given
        Customer customer1 = Customer.builder()
                .uuid(UUID.randomUUID())
                .firstName("John")
                .lastName("Rambo")
                .birthDate(LocalDate.of(1990, 1, 1))
                .documentNumber("ABC123")
                .build();

        Customer customer2 = Customer.builder()
                .uuid(UUID.randomUUID())
                .firstName("Jason")
                .lastName("Bourne")
                .birthDate(LocalDate.of(1980, 12, 1))
                .documentNumber("XYZ323")
                .build();
        Mono<Customer> customerMono = Mono.just(customer1);
        Mockito.when(repositoryMock.getCustomerById(Mockito.any(UUID.class))).thenReturn(customerMono);
        QueryHandler<GetCustomerByUUIDQuery, Customer> getCustomerByIdHandlerMock =
                new GetCustomerByUUIDHandler(repositoryMock);

        // When
        CustomerQueryBus queryBus = new CustomerQueryBus(List.of(getCustomerByIdHandlerMock));

        // Then
        StepVerifier.create(queryBus.handleQuery(new GetCustomerByUUIDQuery(customer2.getUuid())))
                .expectNext(customer1)
                .expectComplete()
                .verify();
    }
}