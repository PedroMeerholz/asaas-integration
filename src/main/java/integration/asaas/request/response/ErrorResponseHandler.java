package integration.asaas.request.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.request.response.error.AsaasErrorList;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
public class ErrorResponseHandler {
    public ResponseEntity handleErrorResponse(HttpResponse<String> response) throws JsonProcessingException {
        if (response.body().isEmpty()) {
            return new ResponseEntity(HttpStatusCode.valueOf(response.statusCode()));
        }
        ObjectMapper mapper = new ObjectMapper();
        AsaasErrorList errors = mapper.readValue(response.body(), AsaasErrorList.class);
        return new ResponseEntity(errors, HttpStatusCode.valueOf(response.statusCode()));
    }
}
