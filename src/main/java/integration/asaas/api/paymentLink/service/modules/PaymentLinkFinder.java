package integration.asaas.api.paymentLink.service.modules;

import integration.asaas.api.common.service.IServiceModule;
import integration.asaas.api.paymentLink.request.PaymentLinkRequestManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentLinkFinder implements IServiceModule {
    private final PaymentLinkRequestManager paymentLinkRequestManager;

    public PaymentLinkFinder(PaymentLinkRequestManager paymentLinkRequestManager) {
        this.paymentLinkRequestManager = paymentLinkRequestManager;
    }

    @Override
    public <T> ResponseEntity<T> execute(T params) {
        return this.find((Map<String, Object>) params);
    }

    private ResponseEntity find(Map<String, Object> params) {
        try {
            return this.paymentLinkRequestManager.list(params);
        } catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
