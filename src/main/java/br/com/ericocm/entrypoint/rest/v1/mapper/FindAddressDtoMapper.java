package br.com.ericocm.entrypoint.rest.v1.mapper;

import br.com.ericocm.entrypoint.rest.v1.dto.FindAddressDto;
import br.com.ericocm.gateway.viacep.dto.ViaCepAddressDto;

public class FindAddressDtoMapper {

    public static FindAddressDto fromViaCepAddress(ViaCepAddressDto viaCepAddressDto) {
        return new FindAddressDto(viaCepAddressDto.getUf(),
                viaCepAddressDto.getComplemento(),
                viaCepAddressDto.getLogradouro(),
                viaCepAddressDto.getBairro(),
                viaCepAddressDto.getLocalidade(),
                viaCepAddressDto.getIbge(),
                viaCepAddressDto.getCep()
        );
    }

}
