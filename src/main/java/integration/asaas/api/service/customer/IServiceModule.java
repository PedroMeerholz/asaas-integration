package integration.asaas.api.service.customer;

import integration.asaas.api.model.customer.Customer;
import org.springframework.http.ResponseEntity;

public interface IServiceModule {
    ResponseEntity execute(Customer customer) throws Exception;
}
