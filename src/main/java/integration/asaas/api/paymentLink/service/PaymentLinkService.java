package integration.asaas.api.paymentLink.service;

import integration.asaas.api.paymentLink.model.PaymentLink;
import integration.asaas.api.paymentLink.service.modules.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentLinkService {
    private final PaymentLinkCreator paymentLinkCreator;
    private final PaymentLinkFinder paymentLinkFinder;
    private final PaymentLinkUpdater paymentLinkUpdater;
    private final PaymentLinkRemover paymentLinkRemover;
    private final PaymentLinkRetriever paymentLinkRetriever;

    public PaymentLinkService(PaymentLinkCreator paymentLinkCreator, PaymentLinkFinder paymentLinkFinder, PaymentLinkUpdater paymentLinkUpdater, PaymentLinkRemover paymentLinkRemover, PaymentLinkRetriever paymentLinkRetriever) {
        this.paymentLinkCreator = paymentLinkCreator;
        this.paymentLinkFinder = paymentLinkFinder;
        this.paymentLinkUpdater = paymentLinkUpdater;
        this.paymentLinkRemover = paymentLinkRemover;
        this.paymentLinkRetriever = paymentLinkRetriever;
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

    public ResponseEntity delete(String paymentLinkId) {
        return this.paymentLinkRemover.execute(paymentLinkId);
    }

    public ResponseEntity restore(String paymentLinkId) {
        return this.paymentLinkRetriever.execute(paymentLinkId);
    }
}
