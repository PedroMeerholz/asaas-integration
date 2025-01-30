package integration.asaas.api.service.customer;

import org.springframework.http.ResponseEntity;

public interface IManyParamsServiceModule {
    <T> ResponseEntity execute(T... args);
}
