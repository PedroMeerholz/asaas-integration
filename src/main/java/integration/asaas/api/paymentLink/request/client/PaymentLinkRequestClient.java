package integration.asaas.api.paymentLink.request.client;

import integration.asaas.api.common.request.client.RequestClient;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpRequest;

@Component
public class PaymentLinkRequestClient extends RequestClient {
    private final String path = "/api/v3/paymentLinks";
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
}
