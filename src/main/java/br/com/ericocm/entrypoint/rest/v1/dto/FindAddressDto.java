package br.com.ericocm.entrypoint.rest.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindAddressDto {
    private String state;
    private String complementaryAddress;
    private String street;
    private String neighborhood;
    private String city;
    private String ibgeCode;
    private String zipCode;
}
