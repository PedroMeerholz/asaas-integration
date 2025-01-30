package integration.asaas.api.customer.service;

import org.springframework.http.ResponseEntity;

public interface IServiceModule {
    <T> ResponseEntity<T> execute(T data);
}
