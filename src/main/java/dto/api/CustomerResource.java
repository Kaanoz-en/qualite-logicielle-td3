package dto.api;

import dto.application.CustomerService;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

public class CustomerResource {
    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Path("/customers/{email}/carts")
    @POST
    public Response confirmCart(@PathParam("email") String email, CartDto cartDto){
        customerService.confirmCart(email, cartDto);
        return Response.ok().build();
    }
}
