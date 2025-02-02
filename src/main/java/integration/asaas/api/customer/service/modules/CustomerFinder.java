package integration.asaas.api.customer.service.modules;

import integration.asaas.api.common.service.IServiceModule;
import integration.asaas.api.customer.request.CustomerRequestManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerFinder implements IServiceModule {
    private final CustomerRequestManager customerRequestManager;

    public CustomerFinder(CustomerRequestManager customerRequestManager) {
        this.customerRequestManager = customerRequestManager;
    }

    @Override
    public <T> ResponseEntity<T> execute(T optionalCustomerId) {
        if (optionalCustomerId == Optional.empty()) {
            return this.findAll();
        }

        String customerId = ((Optional<String>) optionalCustomerId).get();
        return this.findOne(customerId);
    }

    private ResponseEntity findAll() {
        try {
            return this.customerRequestManager.listAllCustomers();
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity findOne(String customerId) {
        try {
            return this.customerRequestManager.listOneCustomer(customerId);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
