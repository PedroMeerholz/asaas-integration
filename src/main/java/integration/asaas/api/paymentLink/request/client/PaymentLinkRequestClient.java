package integration.asaas.api.paymentLink.request.client;

import integration.asaas.api.common.request.client.RequestClient;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Map;

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

    public HttpRequest buildGetRequest(Map<String, Object> params) {
        String url = this.baseUrl + this.path;
        String urlParams = this.buildRequestParams(params);
        url += urlParams;
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Sandbox Integration (Back-end)")
                .header("access_token", this.apiKey)
                .GET()
                .build();
    }

    public HttpRequest buildPutRequest(String body, String pathVariable) {
        String url = this.baseUrl + this.path + "/" + pathVariable;
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("User-Agent", "Sandbox Integration (Back-end)")
                .header("access_token", this.apiKey)
                .PUT(HttpRequest.BodyPublishers.ofString(body))
                .build();
    }

    private String buildRequestParams(Map<String, Object> params) {
        String requestParams = "?";
        boolean firstParam = true;

        for (String paramName:
                params.keySet()) {
            if (params.get(paramName) == null) {
                continue;
            }
            if (!firstParam) {
                requestParams += "&";
            }
            String paramStructure = paramName + "=" + params.get(paramName);
            requestParams += paramStructure;
            firstParam = false;
        }
        return requestParams;
    }
}
