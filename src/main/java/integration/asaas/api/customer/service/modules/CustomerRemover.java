package integration.asaas.api.customer.service.modules;

import integration.asaas.api.customer.service.IServiceModule;
import integration.asaas.api.customer.request.response.CustomerRequestManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerRemover implements IServiceModule {
    private final CustomerRequestManager customerRequestManager;

    public CustomerRemover(CustomerRequestManager customerRequestManager) {
        this.customerRequestManager = customerRequestManager;
    }

    @Override
    public <T> ResponseEntity<T> execute(T customerId) {
        return this.deleteCustomer((String) customerId);
    }

    private ResponseEntity deleteCustomer(String customerId) {
        try {
            return this.customerRequestManager.deleteCustomer(customerId);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
