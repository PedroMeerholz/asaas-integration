package integration.asaas.api.common.service;

import org.springframework.http.ResponseEntity;

public interface IManyParamsServiceModule {
    <T> ResponseEntity execute(T... args);
}
