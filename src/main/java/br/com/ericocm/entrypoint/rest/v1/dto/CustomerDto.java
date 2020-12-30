package br.com.ericocm.entrypoint.rest.v1.dto;

import br.com.ericocm.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String name;
    private String cpf;

    public Customer toCustomer() {
        return new Customer(this.id, this.name, this.cpf);
    }

    public static CustomerDto fromCustomer(Customer customer) {
        return new CustomerDto(customer.id, customer.getName(), customer.getCpf());
    }

    public static List<CustomerDto> fromList(List<Customer> customers) {
        return customers.stream()
                .map(CustomerDto::fromCustomer)
                .collect(Collectors.toList());
    }
}
