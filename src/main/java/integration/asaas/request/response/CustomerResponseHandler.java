package integration.asaas.request.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.request.response.assasresponse.findCustomer.FindAllCustomersResponse;
import integration.asaas.request.response.assasresponse.findCustomer.RetrievedCustomer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
public class CustomerResponseHandler {
    private final ErrorResponseHandler errorResponseHandler;

    public CustomerResponseHandler(ErrorResponseHandler errorResponseHandler) {
        this.errorResponseHandler = errorResponseHandler;
    }

    public ResponseEntity handleResponse(HttpResponse<String> response) throws JsonProcessingException {
        if (response.statusCode() != 200) {
            return this.errorResponseHandler.handleErrorResponse(response);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity handleListAllCustomersResponse(HttpResponse<String> response) throws JsonProcessingException {
        if (response.statusCode() != 200) {
            return this.errorResponseHandler.handleErrorResponse(response);
        }

        ObjectMapper mapper = new ObjectMapper();
        FindAllCustomersResponse allUsers = mapper.readValue(response.body(), FindAllCustomersResponse.class);
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    public ResponseEntity handleListOneCustomerResponse(HttpResponse<String> response) throws JsonProcessingException {
        if (response.statusCode() != 200) {
            return this.errorResponseHandler.handleErrorResponse(response);
        }

        ObjectMapper mapper = new ObjectMapper();
        RetrievedCustomer customer = mapper.readValue(response.body(), RetrievedCustomer.class);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
