package integration.asaas.api.paymentLink.service.modules;

import com.fasterxml.jackson.databind.ObjectMapper;
import integration.asaas.api.common.service.IManyParamsServiceModule;
import integration.asaas.api.paymentLink.model.PaymentLink;
import integration.asaas.api.paymentLink.request.PaymentLinkRequestManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentLinkUpdater implements IManyParamsServiceModule {
    private final PaymentLinkRequestManager requestManager;

    public PaymentLinkUpdater(PaymentLinkRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    @Override
    public <T> ResponseEntity execute(T... args) {
        Map<String, Object> argsMappedData = this.mapArgsData(args);
        return this.update((PaymentLink) argsMappedData.get("paymentLink"), (String) argsMappedData.get("paymentLinkId"));
    }

    private <T> Map<String, Object> mapArgsData(T... args) {
        Map<String, Object> map = new HashMap<>();
        for (T arg : args) {
            if (arg.getClass().equals(PaymentLink.class)) {
                map.put("paymentLink", arg);
            }
            if (arg.getClass().equals(String.class)) {
                map.put("paymentLinkId", arg);
            }
        }
        return map;
    }

    private ResponseEntity update(PaymentLink paymentLinkWithUpdatedData, String paymentLinkId) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String body = mapper.writeValueAsString(paymentLinkWithUpdatedData);
            return this.requestManager.update(body, paymentLinkId);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
