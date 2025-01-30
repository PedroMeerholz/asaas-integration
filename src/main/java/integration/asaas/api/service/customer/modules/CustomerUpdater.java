package integration.asaas.api.service.customer.modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.api.model.customer.Customer;
import integration.asaas.api.service.customer.IManyParamsServiceModule;
import integration.asaas.request.CustomerRequestManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerUpdater implements IManyParamsServiceModule {
    private final CustomerRequestManager customerRequestManager;

    public CustomerUpdater(CustomerRequestManager customerRequestManager) {
        this.customerRequestManager = customerRequestManager;
    }

    @Override
    public <T> ResponseEntity execute(T... args) {
        Map<String, Object> argsMappedData = this.mapArgsData(args);
        return this.update((String) argsMappedData.get("customerId"), (Customer) argsMappedData.get("customer"));
    }

    private <T> Map<String, Object> mapArgsData(T... args) {
        Map<String, Object> map = new HashMap<>();
        for (T arg : args) {
            if (arg.getClass().equals(String.class)) {
                map.put("customerId", arg);
            }
            if (arg.getClass().equals(Customer.class)) {
                map.put("customer", arg);
            }
        }
        return map;
    }

    private ResponseEntity update(String customerId, Customer newCustomerData) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String body = mapper.writeValueAsString(newCustomerData);
            return this.customerRequestManager.updateCustomer(customerId, body);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
