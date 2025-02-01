package integration.asaas.api.paymentLink.model;

public interface IPaymentLink {
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription(String description);
    String getEndDate();
    void setEndDate(String endDate);
    double getValue();
    void setValue(double value);
    String getBillingType();
    void setBillingType(String billingType);
    String getChargeType();
    void setChargeType(String chargeType);
    int getDueDateLimitDays();
    void setDueDateLimitDays(int dueDateLimitDays);
    String getSubscriptionCycle();
    void setSubscriptionCycle(String subscriptionCycle);
    int getMaxInstallmentCount();
    void setMaxInstallmentCount(int maxInstallmentCount);
    String getExternalReference();
    void setExternalReference(String externalReference);
    boolean isNotificationEnabled();
    void setNotificationEnabled(boolean notificationEnabled);
    PaymentLinkCallback getCallback();
    void setCallback(PaymentLinkCallback callback);
    boolean isAddressRequired();
}
