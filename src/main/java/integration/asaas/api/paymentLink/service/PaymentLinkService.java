package integration.asaas.api.paymentLink.service;

import integration.asaas.api.paymentLink.model.PaymentLink;
import integration.asaas.api.paymentLink.service.modules.PaymentLinkCreator;
import integration.asaas.api.paymentLink.service.modules.PaymentLinkFinder;
import integration.asaas.api.paymentLink.service.modules.PaymentLinkUpdater;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentLinkService {
    private final PaymentLinkCreator paymentLinkCreator;
    private final PaymentLinkFinder paymentLinkFinder;
    private final PaymentLinkUpdater paymentLinkUpdater;

    public PaymentLinkService(PaymentLinkCreator paymentLinkCreator, PaymentLinkFinder paymentLinkFinder, PaymentLinkUpdater paymentLinkUpdater) {
        this.paymentLinkCreator = paymentLinkCreator;
        this.paymentLinkFinder = paymentLinkFinder;
        this.paymentLinkUpdater = paymentLinkUpdater;
    }

    public ResponseEntity create(PaymentLink paymentLink) {
        return this.paymentLinkCreator.execute(paymentLink);
    }

    public ResponseEntity find(Map<String, Object> params) {
        return this.paymentLinkFinder.execute(params);
    }

    public ResponseEntity update(PaymentLink paymentLink, String paymentLinkId) {
        return this.paymentLinkUpdater.execute(paymentLink, paymentLinkId);
    }
}
