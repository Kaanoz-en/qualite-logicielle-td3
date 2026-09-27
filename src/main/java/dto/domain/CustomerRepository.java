package dto.domain;

public interface CustomerRepository {
    Customer findCustomerByEmail(String customerEmail);
}
