package br.com.ericocm.entrypoint.rest.v1.dto;

import br.com.ericocm.domain.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPostDto {
    private String name;
    private String cpf;

    public Customer toCustomer() {
        return new Customer(this.name, this.cpf);
    }

    public static CustomerPostDto fromCustomer(Customer customer) {
        return new CustomerPostDto(customer.getName(), customer.getCpf());
    }
}
