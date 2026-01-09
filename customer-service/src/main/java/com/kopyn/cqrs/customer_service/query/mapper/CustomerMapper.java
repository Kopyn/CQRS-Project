package com.kopyn.cqrs.customer_service.query.mapper;

import com.kopyn.cqrs.customer_service.domain.Customer;
import com.kopyn.cqrs.customer_service.query.dto.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO (Customer customer) {
        return new CustomerDTO(customer.getUuid(), customer.getFirstName(), customer.getMiddleName(),
                customer.getLastName(), customer.getBirthDate(), customer.getDocumentNumber());
    }

}
