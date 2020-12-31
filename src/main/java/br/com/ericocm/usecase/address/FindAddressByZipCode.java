package br.com.ericocm.usecase.address;

import br.com.ericocm.entrypoint.rest.v1.dto.FindAddressDto;
import br.com.ericocm.entrypoint.rest.v1.mapper.FindAddressDtoMapper;
import br.com.ericocm.gateway.viacep.ViaCepClient;
import br.com.ericocm.shared.model.ErrorModel;
import br.com.ericocm.shared.model.ProcessResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

@ApplicationScoped
public class FindAddressByZipCode {

    @Inject
    @RestClient
    private ViaCepClient viaCepClient;

    public ProcessResult<FindAddressDto> execute(String zipCode) {
        try {
            return ProcessResult.<FindAddressDto>builder()
                    .success(true)
                    .object(FindAddressDtoMapper.fromViaCepAddress(viaCepClient.findAddress(zipCode)))
                    .build();
        } catch (WebApplicationException e) {
            if (e.getResponse().getStatus() == BAD_REQUEST.getStatusCode()) {
                return resultErrorWithMessage("Check the zipcode informed");
            } else {
                return resultErrorWithMessage("Try again later");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return resultErrorWithMessage("Try again later");
        }
    }

    private ProcessResult<FindAddressDto> resultErrorWithMessage(String message) {
        return ProcessResult.<FindAddressDto>builder()
                .success(false)
                .error(ErrorModel.builder()
                        .title("Error searching address")
                        .message(message)
                        .build())
                .build();
    }

}
