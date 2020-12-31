package br.com.ericocm.entrypoint.rest.v1.mapper;

import br.com.ericocm.domain.entity.Customer;
import br.com.ericocm.entrypoint.rest.v1.dto.CustomerPostDto;

public class CustomerPostDtoMapper {

    public static Customer toCustomer(CustomerPostDto customerPostDto) {
        return new Customer(customerPostDto.getName(), customerPostDto.getCpf());
    }

    public static CustomerPostDto fromCustomer(Customer customer) {
        return new CustomerPostDto(customer.getName(), customer.getCpf());
    }
}
