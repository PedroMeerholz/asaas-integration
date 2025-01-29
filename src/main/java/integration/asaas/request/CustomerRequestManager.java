package integration.asaas.request;

import integration.asaas.api.model.customer.Customer;
import integration.asaas.request.response.CustomerResponseHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class CustomerRequestManager {
    private final CustomerRequestBuilder requestBuilder;
    private final CustomerResponseHandler responseHandler;

    public CustomerRequestManager(CustomerRequestBuilder requestBuilder, CustomerResponseHandler responseHandler) {
        this.requestBuilder = requestBuilder;
        this.responseHandler = responseHandler;
    }

    public ResponseEntity createCustomer(Customer customer) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestBuilder.buildPostRequest(customer);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleResponse(response);
    }

    public ResponseEntity deleteCustomer(String customerId) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestBuilder.buildDeleteRequest(customerId);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleResponse(response);
    }

    public ResponseEntity listAllCustomers() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestBuilder.buildGetRequest();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleListAllCustomersResponse(response);
    }

    public ResponseEntity listOneCustomer(String customerId) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestBuilder.buildGetRequestWithPathVariable(customerId);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleListOneCustomerResponse(response);
    }

    public ResponseEntity updateCustomer(String customerId, String body) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = this.requestBuilder.buildPutRequestWithPathVariable(customerId, body);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return this.responseHandler.handleResponse(response);
    }
}
