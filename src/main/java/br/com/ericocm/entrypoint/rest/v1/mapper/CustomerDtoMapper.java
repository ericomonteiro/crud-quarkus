package br.com.ericocm.entrypoint.rest.v1.mapper;

import br.com.ericocm.domain.entity.Customer;
import br.com.ericocm.entrypoint.rest.v1.dto.CustomerDto;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerDtoMapper {

    public static Customer toCustomer(CustomerDto customerDto) {
        return new Customer(customerDto.getId(), customerDto.getName(), customerDto.getCpf());
    }

    public static CustomerDto fromCustomer(Customer customer) {
        return new CustomerDto(customer.id, customer.getName(), customer.getCpf());
    }

    public static List<CustomerDto> fromList(List<Customer> customers) {
        return customers.stream()
                .map(CustomerDtoMapper::fromCustomer)
                .collect(Collectors.toList());
    }

}
