package integration.asaas.api.paymentLink.request;

import integration.asaas.api.paymentLink.request.client.PaymentLinkRequestClient;
import integration.asaas.api.paymentLink.request.response.PaymentLinkResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class PaymentLinkRequestManager {
    private final PaymentLinkRequestClient requestClient;
    private final PaymentLinkResponseHandler responseHandler;

    public PaymentLinkRequestManager(PaymentLinkRequestClient requestClient, PaymentLinkResponseHandler responseHandler) {
        this.requestClient = requestClient;
        this.responseHandler = responseHandler;
    }

    public ResponseEntity create(String body) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestClient.buildPostRequest(body);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleResponse(response);
    }
}
