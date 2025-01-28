package integration.asaas.api.service.customer.modules;

import integration.asaas.api.model.customer.Customer;
import integration.asaas.api.service.customer.IServiceModule;
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
    public <T> ResponseEntity<T> execute(T customer) {
        return this.createCustomer((Customer) customer);
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
