package br.com.ericocm.entrypoint.rest.v1;

import br.com.ericocm.usecase.address.FindAddressByZipCode;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Path("v1/address")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressController {

    private FindAddressByZipCode findAddressByZipCode;

    @Inject
    public AddressController(FindAddressByZipCode findAddressByZipCode) {
        this.findAddressByZipCode = findAddressByZipCode;
    }


    @GET
    @Path("zipcode/{zipCode}")
    public Response findAddress (@PathParam("zipCode") String zipCode) {

        var result = findAddressByZipCode.execute(zipCode);

        if (result.success) {
            return Response
                    .ok(result.get())
                    .build();
        } else {
            return Response
                    .status(BAD_REQUEST)
                    .entity(result.errors)
                    .build();
        }
    }

}
