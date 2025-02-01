package integration.asaas.api.common.service;

import org.springframework.http.ResponseEntity;

public interface IServiceModule {
    <T> ResponseEntity<T> execute(T data);
}
