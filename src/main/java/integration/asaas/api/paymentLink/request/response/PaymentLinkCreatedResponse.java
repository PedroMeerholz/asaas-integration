package integration.asaas.api.paymentLink.request.response;

public class PaymentLinkCreatedResponse {
    private String id;
    private String name;
    private double value;
    private boolean active;
    private String chargeType;
    private String url;
    private String billingType;
    private String subscriptionCycle;
    private String description;
    private String endDate;
    private String deleted;
    private int viewCount;
    private int maxInstallmentCount;
    private int dueDateLimitDays;
    private boolean notificationEnabled;
    private boolean isAddressRequired;
    private String externalReference;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public String getSubscriptionCycle() {
        return subscriptionCycle;
    }

    public void setSubscriptionCycle(String subscriptionCycle) {
        this.subscriptionCycle = subscriptionCycle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getMaxInstallmentCount() {
        return maxInstallmentCount;
    }

    public void setMaxInstallmentCount(int maxInstallmentCount) {
        this.maxInstallmentCount = maxInstallmentCount;
    }

    public int getDueDateLimitDays() {
        return dueDateLimitDays;
    }

    public void setDueDateLimitDays(int dueDateLimitDays) {
        this.dueDateLimitDays = dueDateLimitDays;
    }

    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    public void setNotificationEnabled(boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }

    public boolean isAddressRequired() {
        return isAddressRequired;
    }

    public void setAddressRequired(boolean idAddressRequired) {
        isAddressRequired = idAddressRequired;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }
}
