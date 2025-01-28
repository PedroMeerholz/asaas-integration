package integration.asaas.api.service.customer;

import integration.asaas.api.model.customer.Customer;
import integration.asaas.request.CustomerRequestManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreator implements IServiceModule {
    private final CustomerRequestManager customerRequestManager;

    public CustomerCreator(CustomerRequestManager customerRequestManager) {
        this.customerRequestManager = customerRequestManager;
    }

    @Override
    public ResponseEntity execute(Customer customer) {
        return this.createCustomer(customer);
    }

    private ResponseEntity createCustomer(Customer customer) {
        try {
            return this.customerRequestManager.createCustomer(customer);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
