package integration.asaas.api.paymentLink.request.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.api.common.request.response.error.ErrorResponseHandler;
import integration.asaas.api.common.request.response.handler.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
public class PaymentLinkResponseHandler extends ResponseHandler {

    public PaymentLinkResponseHandler(ErrorResponseHandler errorResponseHandler) {
       super(errorResponseHandler);
    }

    public ResponseEntity handleResponse(HttpResponse<String> response) throws JsonProcessingException {
        if (response.statusCode() != 200) {
            return this.errorResponseHandler.handleErrorResponse(response);
        }
        String responseBody = this.adjustResponseBody(response);
        ObjectMapper mapper = new ObjectMapper();
        PaymentLinkRetrieved createdResponse = mapper.readValue(responseBody, PaymentLinkRetrieved.class);
        return new ResponseEntity(createdResponse, HttpStatus.OK);
    }

    public ResponseEntity handleListResponse(HttpResponse<String> response) throws JsonProcessingException {
        if (response.statusCode() != 200) {
            return this.errorResponseHandler.handleErrorResponse(response);
        }
        String responseBody = this.adjustResponseBody(response);
        ObjectMapper mapper = new ObjectMapper();
        PaymentLinkRetrievedList listResponse = mapper.readValue(responseBody, PaymentLinkRetrievedList.class);
        return new ResponseEntity(listResponse, HttpStatusCode.valueOf(response.statusCode()));
    }

    private String adjustResponseBody(HttpResponse<String> response) {
        String responseBody = response.body();
        return responseBody.replace("isAddressRequired", "addressRequired");
    }
}
