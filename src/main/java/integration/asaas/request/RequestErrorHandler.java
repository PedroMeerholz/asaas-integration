package integration.asaas.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.request.assasresponse.AsaasErrorList;
import org.springframework.stereotype.Component;

@Component
public class RequestErrorHandler {
    public AsaasErrorList getErrors(String response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, AsaasErrorList.class);
    }
}
