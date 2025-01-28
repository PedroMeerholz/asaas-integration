package integration.asaas.api.service.customer;

import integration.asaas.api.model.customer.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerCreator customerCreator;

    public CustomerService(CustomerCreator customerCreator) {
        this.customerCreator = customerCreator;
    }

    public ResponseEntity add(Customer customer) {
        return this.customerCreator.execute(customer);
    }
}
