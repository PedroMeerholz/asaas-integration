package integration.asaas.api.paymentLink.controller;

import integration.asaas.api.paymentLink.model.PaymentLink;
import integration.asaas.api.paymentLink.service.PaymentLinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paymentLink")
public class PaymentLinkController {
    private final PaymentLinkService service;

    public PaymentLinkController(PaymentLinkService paymentLinkService) {
        this.service = paymentLinkService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody PaymentLink paymentLink) {
        return this.service.create(paymentLink);
    }
}
