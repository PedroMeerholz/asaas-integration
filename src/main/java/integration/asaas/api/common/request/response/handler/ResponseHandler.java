package integration.asaas.api.common.request.response.handler;

import integration.asaas.api.common.request.response.error.ErrorResponseHandler;
import org.springframework.stereotype.Component;

@Component
public abstract class ResponseHandler {
    protected final ErrorResponseHandler errorResponseHandler;

    public ResponseHandler(ErrorResponseHandler errorResponseHandler) {
        this.errorResponseHandler = errorResponseHandler;
    }
}
