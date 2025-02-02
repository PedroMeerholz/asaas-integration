package integration.asaas.api.paymentLink.service;

import integration.asaas.api.paymentLink.model.PaymentLink;
import integration.asaas.api.paymentLink.service.modules.PaymentLinkCreator;
import integration.asaas.api.paymentLink.service.modules.PaymentLinkFinder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentLinkService {
    private final PaymentLinkCreator paymentLinkCreator;
    private final PaymentLinkFinder paymentLinkFinder;

    public PaymentLinkService(PaymentLinkCreator paymentLinkCreator, PaymentLinkFinder paymentLinkFinder) {
        this.paymentLinkCreator = paymentLinkCreator;
        this.paymentLinkFinder = paymentLinkFinder;
    }

    public ResponseEntity create(PaymentLink paymentLink) {
        return this.paymentLinkCreator.execute(paymentLink);
    }

    public ResponseEntity find(Map<String, Object> params) {
        return this.paymentLinkFinder.execute(params);
    }
}
