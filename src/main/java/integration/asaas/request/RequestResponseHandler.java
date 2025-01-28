package integration.asaas.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import integration.asaas.request.assasresponse.AsaasErrorList;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
public class RequestResponseHandler {
    private RequestErrorHandler requestErrorHandler;

    public RequestResponseHandler(RequestErrorHandler requestErrorHandler) {
        this.requestErrorHandler = requestErrorHandler;
    }

    public ResponseEntity handleResponse(HttpResponse<String> response) throws JsonProcessingException {
        if (response.statusCode() != 200) {
            AsaasErrorList errors = this.requestErrorHandler.getErrors(response.body());
            return new ResponseEntity(errors, HttpStatusCode.valueOf(response.statusCode()));
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
