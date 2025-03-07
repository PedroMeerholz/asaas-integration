package integration.asaas.api.paymentLink.controller;

import integration.asaas.api.paymentLink.model.PaymentLink;
import integration.asaas.api.paymentLink.service.PaymentLinkService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping(value = "/find")
    public ResponseEntity find(@PathParam("active") boolean active,
                               @PathParam("includeDeleted") boolean includeDeleted,
                               @PathParam("name") String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("active", active);
        params.put("includeDeleted", includeDeleted);
        params.put("name", name);
        params.put("offset", 0);
        params.put("limit", 10);
        return this.service.find(params);
    }

    @PutMapping(value = "/update/{paymentLinkId}")
    public ResponseEntity update(@RequestBody PaymentLink paymentLink, @PathVariable("paymentLinkId") String paymentLinkId) {
        return this.service.update(paymentLink, paymentLinkId);
    }

    @DeleteMapping(value = "/delete/{paymentLinkId}")
    public ResponseEntity delete(@PathVariable("paymentLinkId") String paymentLinkId) {
        return this.service.delete(paymentLinkId);
    }
    @PostMapping(value = "/recover/{paymentLinkId}")
    public ResponseEntity recover(@PathVariable("paymentLinkId") String paymentLinkId) {
        return this.service.restore(paymentLinkId);
    }
}
