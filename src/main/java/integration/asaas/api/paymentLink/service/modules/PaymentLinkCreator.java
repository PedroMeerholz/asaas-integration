package integration.asaas.api.paymentLink.service.modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.api.common.service.IServiceModule;
import integration.asaas.api.paymentLink.model.PaymentLink;
import integration.asaas.api.paymentLink.request.PaymentLinkRequestManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentLinkCreator implements IServiceModule {
    private final PaymentLinkRequestManager requestManager;

    public PaymentLinkCreator(PaymentLinkRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override
    public <T> ResponseEntity<T> execute(T data) {
        return this.create((PaymentLink) data);
    }

    private ResponseEntity create(PaymentLink paymentLink) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String body = mapper.writeValueAsString(paymentLink);
            body = body.replace("addressRequired", "isAddressRequired");
            return this.requestManager.create(body);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
