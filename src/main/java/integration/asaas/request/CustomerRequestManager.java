package integration.asaas.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.api.model.customer.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class CustomerRequestManager extends RequestManager {
    private String path = "/api/v3/customers";

    public CustomerRequestManager(RequestResponseHandler requestResponseHandler) {
        super(requestResponseHandler);
    }

    public ResponseEntity createCustomer(Customer customer) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.buildPostRequest(customer);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.handleResponse(response);
    }

    public ResponseEntity deleteCustomer(String customerId) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.buildDeleteRequest(customerId);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.handleResponse(response);
    }

    private HttpRequest buildPostRequest(Customer customer) throws JsonProcessingException {
        String url = this.baseUrl + this.path;
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(customer);
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Sandbox Integration (Back-end)")
                .header("access_token", this.apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
    }

    private HttpRequest buildDeleteRequest(String customerId) {
        String url = this.baseUrl + this.path + String.format("/%s", customerId);
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Sandbox Integration (Back-end)")
                .header("access_token", this.apiKey)
                .DELETE()
                .build();
    }
}
