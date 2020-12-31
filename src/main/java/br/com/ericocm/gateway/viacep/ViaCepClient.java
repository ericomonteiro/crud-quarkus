package br.com.ericocm.gateway.viacep;

import br.com.ericocm.gateway.viacep.dto.ViaCepAddressDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;


@RegisterRestClient(configKey = "viacep-api")
@ApplicationScoped
public interface ViaCepClient {

    @GET
    @Path("/ws/{zipCode}/json/")
    @Produces(MediaType.APPLICATION_JSON)
    public ViaCepAddressDto findAddress(@PathParam("zipCode") String zipCode);
}
