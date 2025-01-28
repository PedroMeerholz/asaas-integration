package integration.asaas.api.service.customer;

import integration.asaas.api.model.customer.Customer;
import integration.asaas.api.service.customer.modules.CustomerCreator;
import integration.asaas.api.service.customer.modules.CustomerRemover;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerCreator customerCreator;
    private final CustomerRemover customerRemover;

    public CustomerService(CustomerCreator customerCreator, CustomerRemover customerRemover) {
        this.customerCreator = customerCreator;
        this.customerRemover = customerRemover;
    }

    public ResponseEntity add(Customer customer) {
        return this.customerCreator.execute(customer);
    }

    public ResponseEntity delete(String customerId) {
        return this.customerRemover.execute(customerId);
    }
}
