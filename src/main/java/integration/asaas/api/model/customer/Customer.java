package integration.asaas.api.model.customer;

public class Customer implements ICustomer {
    private String name;
    private String cpfCnpj;
    private String email;
    private String phone;
    private String mobilePhone;
    private String address;
    private String addressNumber;
    private String complement;
    private String province;
    private String postalCode;
    private String externalReference;
    private boolean notificationDisabled;
    private String additionalEmails;
    private String municipalInscription;
    private String stateInscription;
    private String observations;
    private String groupName;
    private String company;
    private boolean foreignCustomer;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    @Override
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getMobilePhone() {
        return mobilePhone;
    }

    @Override
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddressNumber() {
        return addressNumber;
    }

    @Override
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    @Override
    public String getComplement() {
        return complement;
    }

    @Override
    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String getProvince() {
        return province;
    }

    @Override
    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
    public boolean isNotificationDisabled() {
        return notificationDisabled;
    }

    @Override
    public void setNotificationDisabled(boolean notificationDisabled) {
        this.notificationDisabled = notificationDisabled;
    }

    @Override
    public String getAdditionalEmails() {
        return additionalEmails;
    }

    @Override
    public void setAdditionalEmails(String additionalEmails) {
        this.additionalEmails = additionalEmails;
    }

    @Override
    public String getMunicipalInscription() {
        return municipalInscription;
    }

    @Override
    public void setMunicipalInscription(String municipalInscription) {
        this.municipalInscription = municipalInscription;
    }

    @Override
    public String getStateInscription() {
        return stateInscription;
    }

    @Override
    public void setStateInscription(String stateInscription) {
        this.stateInscription = stateInscription;
    }

    @Override
    public String getObservations() {
        return observations;
    }

    @Override
    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String getGroupName() {
        return groupName;
    }

    @Override
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String getCompany() {
        return company;
    }

    @Override
    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public boolean isForeignCustomer() {
        return foreignCustomer;
    }

    @Override
    public void setForeignCustomer(boolean foreignCustomer) {
        this.foreignCustomer = foreignCustomer;
    }
}
