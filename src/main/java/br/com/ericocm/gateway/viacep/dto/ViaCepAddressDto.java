package br.com.ericocm.gateway.viacep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaCepAddressDto{
	private String uf;
	private String complemento;
	private String ddd;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String ibge;
	private String siafi;
	private String gia;
	private String cep;
}
