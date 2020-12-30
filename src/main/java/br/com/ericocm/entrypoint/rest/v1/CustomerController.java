package br.com.ericocm.entrypoint.rest.v1;

import br.com.ericocm.domain.entity.Customer;
import br.com.ericocm.entrypoint.rest.v1.dto.CustomerDto;
import br.com.ericocm.entrypoint.rest.v1.dto.CustomerPostDto;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("v1/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {


    @GET
    public List<CustomerDto> listAll() {
        return CustomerDto.fromList(Customer.listAll());
    }

    @GET
    @Path("/{id}")
    public CustomerDto findById(Long id) {
        return CustomerDto.fromCustomer(Customer.findById(id));
    }

    @POST
    @Transactional
    public Response createCustomer(CustomerPostDto customerDto) {
        Customer customer = customerDto.toCustomer();
        Customer.persist(customer);
        return Response
                .created(URI.create("v1/customer/"))
                .entity(CustomerDto.fromCustomer(customer))
                .build();
    }


}
