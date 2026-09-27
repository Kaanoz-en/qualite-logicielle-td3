package dto.application;

import dto.api.CartDto;
import dto.domain.Customer;
import dto.domain.CustomerRepository;

public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void confirmCart(String customerEmail, CartDto cartDto) {
        Customer customer = customerRepository.findCustomerByEmail(customerEmail);
        if (customer != null){
            customer.confirmCart(cartDto);
        }
    }
}
