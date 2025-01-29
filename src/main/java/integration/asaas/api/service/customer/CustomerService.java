package integration.asaas.api.service.customer;

import integration.asaas.api.model.customer.Customer;
import integration.asaas.api.service.customer.modules.CustomerCreator;
import integration.asaas.api.service.customer.modules.CustomerFinder;
import integration.asaas.api.service.customer.modules.CustomerRemover;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerCreator customerCreator;
    private final CustomerRemover customerRemover;
    private final CustomerFinder customerFinder;

    public CustomerService(CustomerCreator customerCreator, CustomerRemover customerRemover, CustomerFinder customerFinder) {
        this.customerCreator = customerCreator;
        this.customerRemover = customerRemover;
        this.customerFinder = customerFinder;
    }

    public ResponseEntity add(Customer customer) {
        return this.customerCreator.execute(customer);
    }

    public ResponseEntity delete(String customerId) {
        return this.customerRemover.execute(customerId);
    }

    public ResponseEntity find(Optional<String> customerId) {
        return this.customerFinder.execute(customerId);
    }
}
