package integration.asaas.api.service.customer;

import org.springframework.http.ResponseEntity;

public interface IServiceModule {
    <T> ResponseEntity<T> execute(T data);
}
