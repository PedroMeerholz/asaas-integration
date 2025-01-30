package integration.asaas.api.service.customer;

import integration.asaas.api.model.customer.Customer;
import integration.asaas.api.service.customer.modules.CustomerCreator;
import integration.asaas.api.service.customer.modules.CustomerFinder;
import integration.asaas.api.service.customer.modules.CustomerRemover;
import integration.asaas.api.service.customer.modules.CustomerUpdater;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerCreator customerCreator;
    private final CustomerRemover customerRemover;
    private final CustomerFinder customerFinder;
    private final CustomerUpdater customerUpdater;

    public CustomerService(CustomerCreator customerCreator, CustomerRemover customerRemover, CustomerFinder customerFinder, CustomerUpdater customerUpdater) {
        this.customerCreator = customerCreator;
        this.customerRemover = customerRemover;
        this.customerFinder = customerFinder;
        this.customerUpdater = customerUpdater;
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

    public ResponseEntity update(String customerId, Customer newCustomerData) {
        return this.customerUpdater.execute(customerId, newCustomerData);
    }
}
