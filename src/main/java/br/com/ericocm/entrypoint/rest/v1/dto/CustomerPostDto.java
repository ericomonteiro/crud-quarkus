package br.com.ericocm.entrypoint.rest.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPostDto{
    private String name;
    private String cpf;
}
