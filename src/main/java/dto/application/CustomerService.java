package dto.application;

import dto.domain.Cart;
import dto.domain.Customer;
import dto.domain.CustomerRepository;

public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CartAssembler cartAssembler;

    public CustomerService(CustomerRepository customerRepository, CartAssembler cartAssembler) {

        this.customerRepository = customerRepository;
        this.cartAssembler = cartAssembler;
    }

    public void confirmCart(String customerEmail, CartDto cartDto) {
        Customer customer = customerRepository.findCustomerByEmail(customerEmail);
        if (customer != null){
            Cart cart = cartAssembler.fromDto(cartDto);
            customer.confirmCart(cart);
        }
    }
}
