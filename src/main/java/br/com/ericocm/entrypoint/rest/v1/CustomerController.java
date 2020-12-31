package br.com.ericocm.entrypoint.rest.v1;

import br.com.ericocm.domain.entity.Customer;
import br.com.ericocm.entrypoint.rest.v1.dto.CustomerDto;
import br.com.ericocm.entrypoint.rest.v1.dto.CustomerPostDto;
import br.com.ericocm.entrypoint.rest.v1.mapper.CustomerDtoMapper;
import br.com.ericocm.entrypoint.rest.v1.mapper.CustomerPostDtoMapper;
import br.com.ericocm.usecase.customer.CreateCustomer;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import static javax.ws.rs.core.Response.Status.PRECONDITION_FAILED;

@Path("v1/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {

    private final CreateCustomer createCustomer;

    @Inject
    public CustomerController(CreateCustomer createCustomer) {
        this.createCustomer = createCustomer;
    }

    @GET
    public List<CustomerDto> listAll() {
        return CustomerDtoMapper.fromList(Customer.listAll());
    }

    @GET
    @Path("/{id}")
    public CustomerDto findById(Long id) {
        return CustomerDtoMapper.fromCustomer(Customer.findById(id));
    }

    @POST
    public Response createCustomer(CustomerPostDto customerPostDtoDto) {

        var result = createCustomer.execute(CustomerPostDtoMapper.toCustomer(customerPostDtoDto));

        if (result.success) {
            var customerResult = result.get();
            return Response
                    .created(URI.create("v1/customer/" + customerResult.id))
                    .entity(CustomerDtoMapper.fromCustomer(customerResult))
                    .build();
        } else {
            return Response
                    .status(PRECONDITION_FAILED)
                    .entity(result.errors)
                    .build();
        }
    }
}
