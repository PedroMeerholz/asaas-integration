package integration.asaas.api.paymentLink.service.modules;

import integration.asaas.api.common.service.IServiceModule;
import integration.asaas.api.paymentLink.request.PaymentLinkRequestManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentLinkRemover implements IServiceModule {
    private final PaymentLinkRequestManager requestManager;

    public PaymentLinkRemover(PaymentLinkRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override
    public <T> ResponseEntity<T> execute(T data) {
        return this.delete((String) data);
    }

    private ResponseEntity delete(String paymentLinkId) {
        try {
            return this.requestManager.delete(paymentLinkId);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
