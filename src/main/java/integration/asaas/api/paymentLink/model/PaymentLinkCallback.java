package integration.asaas.api.paymentLink.model;

public class PaymentLinkCallback {
    private String successUrl;
    private boolean autoRedirect;

    public PaymentLinkCallback() {
        this.autoRedirect = false;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public boolean isAutoRedirect() {
        return autoRedirect;
    }

    public void setAutoRedirect(boolean autoRedirect) {
        this.autoRedirect = autoRedirect;
    }
}
