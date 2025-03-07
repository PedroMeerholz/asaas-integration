package integration.asaas.api.paymentLink.service.modules;

import integration.asaas.api.common.service.IServiceModule;
import integration.asaas.api.paymentLink.request.PaymentLinkRequestManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentLinkRetriever implements IServiceModule {
    private final PaymentLinkRequestManager requestManager;

    public PaymentLinkRetriever(PaymentLinkRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override
    public <T> ResponseEntity<T> execute(T data) {
        return this.restore((String) data);
    }

    private ResponseEntity restore(String paymentLinkId) {
        try {
            return this.requestManager.restore(paymentLinkId);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
