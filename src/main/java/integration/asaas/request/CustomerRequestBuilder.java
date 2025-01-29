package integration.asaas.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.api.model.customer.Customer;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpRequest;

@Component
public class CustomerRequestBuilder {
    protected final String baseUrl = "https://sandbox.asaas.com";
    protected final String apiKey = "";
    private String path = "/api/v3/customers";

    public HttpRequest buildPostRequest(Customer customer) throws JsonProcessingException {
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

    public HttpRequest buildDeleteRequest(String customerId) {
        String url = this.baseUrl + this.path + String.format("/%s", customerId);
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Sandbox Integration (Back-end)")
                .header("access_token", this.apiKey)
                .DELETE()
                .build();
    }

    public HttpRequest buildGetRequest() {
        String url = this.baseUrl + this.path;
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Sandbox Integration (Back-end)")
                .header("access_token", this.apiKey)
                .GET()
                .build();
    }

    public HttpRequest buildGetRequestWithPathVariable(String variable) {
        String url = this.baseUrl + this.path + "/" + variable;
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Sandbox Integration (Back-end)")
                .header("access_token", this.apiKey)
                .GET()
                .build();
    }
}
