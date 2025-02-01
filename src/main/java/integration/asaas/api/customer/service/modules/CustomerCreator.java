package integration.asaas.api.customer.service.modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.api.customer.model.Customer;
import integration.asaas.api.common.service.IServiceModule;
import integration.asaas.api.customer.request.response.CustomerRequestManager;
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
            ObjectMapper mapper = new ObjectMapper();
            String body = mapper.writeValueAsString(customer);
            return this.customerRequestManager.createCustomer(body);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
