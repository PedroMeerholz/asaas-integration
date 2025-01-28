package integration.asaas.api.controller;

import integration.asaas.api.model.customer.Customer;
import integration.asaas.api.service.customer.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Customer customer) {
        return this.service.add(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity delete(@PathVariable("customerId") String customerId) {
        return this.service.delete(customerId);
    }
}
