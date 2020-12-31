package br.com.ericocm.entrypoint.rest.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CustomerDto{
    private Long id;
    private String name;
    private String cpf;
}
