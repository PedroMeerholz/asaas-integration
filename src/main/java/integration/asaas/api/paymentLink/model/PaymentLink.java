package integration.asaas.api.paymentLink.model;

public class PaymentLink implements IPaymentLink {
    private String name;
    private String description;
    private String endDate;
    private double value;
    private String billingType;
    private String chargeType;
    private int dueDateLimitDays;
    private String subscriptionCycle;
    private int maxInstallmentCount;
    private String externalReference;
    private boolean notificationEnabled;
    private PaymentLinkCallback callback;
    private final boolean isAddressRequired;

    public PaymentLink() {
        this.isAddressRequired = true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getEndDate() {
        return endDate;
    }

    @Override
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String getBillingType() {
        return billingType;
    }

    @Override
    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    @Override
    public String getChargeType() {
        return chargeType;
    }

    @Override
    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public int getDueDateLimitDays() {
        return dueDateLimitDays;
    }

    public void setDueDateLimitDays(int dueDateLimitDays) {
        this.dueDateLimitDays = dueDateLimitDays;
    }

    @Override
    public String getSubscriptionCycle() {
        return subscriptionCycle;
    }

    @Override
    public void setSubscriptionCycle(String subscriptionCycle) {
        this.subscriptionCycle = subscriptionCycle;
    }

    @Override
    public int getMaxInstallmentCount() {
        return maxInstallmentCount;
    }

    @Override
    public void setMaxInstallmentCount(int maxInstallmentCount) {
        this.maxInstallmentCount = maxInstallmentCount;
    }

    @Override
    public String getExternalReference() {
        return externalReference;
    }

    @Override
    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }

    @Override
    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    @Override
    public void setNotificationEnabled(boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }

    @Override
    public PaymentLinkCallback getCallback() {
        return callback;
    }

    @Override
    public void setCallback(PaymentLinkCallback callback) {
        this.callback = callback;
    }

    @Override
    public boolean isAddressRequired() {
        return isAddressRequired;
    }
}
