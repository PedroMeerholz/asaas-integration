package integration.asaas.api.paymentLink.request.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.api.common.request.response.error.ErrorResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
public class PaymentLinkResponseHandler {
    private final ErrorResponseHandler errorResponseHandler;

    public PaymentLinkResponseHandler(ErrorResponseHandler errorResponseHandler) {
        this.errorResponseHandler = errorResponseHandler;
    }

    public ResponseEntity handleResponse(HttpResponse<String> response) throws JsonProcessingException {
        if (response.statusCode() != 200) {
            return this.errorResponseHandler.handleErrorResponse(response);
        }
        String responseBody = this.adjustResponseBody(response);
        ObjectMapper mapper = new ObjectMapper();
        PaymentLinkCreatedResponse createdResponse = mapper.readValue(responseBody, PaymentLinkCreatedResponse.class);
        return new ResponseEntity(createdResponse, HttpStatus.OK);
    }

    private String adjustResponseBody(HttpResponse<String> response) {
        String responseBody = response.body();
        return responseBody.replace("isAddressRequired", "addressRequired");
    }
}
