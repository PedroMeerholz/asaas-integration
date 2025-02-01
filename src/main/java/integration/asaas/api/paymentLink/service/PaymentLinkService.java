package integration.asaas.api.paymentLink.service;

import integration.asaas.api.paymentLink.model.PaymentLink;
import integration.asaas.api.paymentLink.service.modules.PaymentLinkCreator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentLinkService {
    private final PaymentLinkCreator paymentLinkCreator;

    public PaymentLinkService(PaymentLinkCreator paymentLinkCreator) {
        this.paymentLinkCreator = paymentLinkCreator;
    }

    public ResponseEntity create(PaymentLink paymentLink) {
        return this.paymentLinkCreator.execute(paymentLink);
    }
}
