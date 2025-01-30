package integration.asaas.api.customer.service;

import org.springframework.http.ResponseEntity;

public interface IManyParamsServiceModule {
    <T> ResponseEntity execute(T... args);
}
