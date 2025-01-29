package integration.asaas.request.client;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpRequest;

@Component
public class CustomerRequestClient {
    protected final String baseUrl = "https://sandbox.asaas.com";
    protected final String apiKey = "";
    private final String path = "/api/v3/customers";

    public HttpRequest buildPostRequest(String body) {
        String url = this.baseUrl + this.path;
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Sandbox Integration (Back-end)")
                .header("access_token", this.apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
    }

    public HttpRequest buildDeleteRequestWithPathVariable(String variable) {
        String url = this.baseUrl + this.path + "/" + variable;
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

    public HttpRequest buildPutRequestWithPathVariable(String variable, String body) {
        String url = this.baseUrl + this.path + "/" + variable;
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Sandbox Integration (Back-end)")
                .header("access_token", this.apiKey)
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();
    }
}
