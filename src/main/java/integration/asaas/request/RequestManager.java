package integration.asaas.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
public abstract class RequestManager {
    protected final String baseUrl = "https://sandbox.asaas.com";
    protected final String apiKey = "";
    private final RequestResponseHandler requestResponseHandler;

    protected RequestManager(RequestResponseHandler requestResponseHandler) {
        this.requestResponseHandler = requestResponseHandler;
    }

    protected ResponseEntity handleResponse(HttpResponse<String> response) throws JsonProcessingException {
        return this.requestResponseHandler.handleResponse(response);
    }
}
