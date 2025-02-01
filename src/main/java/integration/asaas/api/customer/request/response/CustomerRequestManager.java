package integration.asaas.api.customer.request.response;

import integration.asaas.api.customer.request.client.CustomerRequestClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class CustomerRequestManager {
    private final CustomerRequestClient requestClient;
    private final CustomerResponseHandler responseHandler;

    public CustomerRequestManager(CustomerRequestClient requestClient, CustomerResponseHandler responseHandler) {
        this.requestClient = requestClient;
        this.responseHandler = responseHandler;
    }

    public ResponseEntity createCustomer(String body) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestClient.buildPostRequest(body);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleResponse(response);
    }

    public ResponseEntity deleteCustomer(String customerId) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestClient.buildDeleteRequestWithPathVariable(customerId);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleResponse(response);
    }

    public ResponseEntity listAllCustomers() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestClient.buildGetRequest();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleListAllCustomersResponse(response);
    }

    public ResponseEntity listOneCustomer(String customerId) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestClient.buildGetRequestWithPathVariable(customerId);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleListOneCustomerResponse(response);
    }

    public ResponseEntity updateCustomer(String customerId, String body) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestClient.buildPutRequestWithPathVariable(customerId, body);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleResponse(response);
    }
}
