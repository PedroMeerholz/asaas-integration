package integration.asaas.api.model.customer;

public interface ICustomer {
    String getName();
    void setName(String name);
    String getCpfCnpj();
    void setCpfCnpj(String cpfCnpj);
    String getEmail();
    void setEmail(String email);
    String getPhone();
    void setPhone(String phone);

    String getMobilePhone();

    void setMobilePhone(String mobilePhone);

    String getAddress();

    void setAddress(String address);

    String getAddressNumber();

    void setAddressNumber(String addressNumber);

    String getComplement();

    void setComplement(String complement);

    String getProvince();

    void setProvince(String province);

    String getPostalCode();

    void setPostalCode(String postalCode);

    String getExternalReference();

    void setExternalReference(String externalReference);

    boolean isNotificationDisabled();

    void setNotificationDisabled(boolean notificationDisabled);

    String getAdditionalEmails();

    void setAdditionalEmails(String additionalEmails);

    String getMunicipalInscription();

    void setMunicipalInscription(String municipalInscription);

    String getStateInscription();

    void setStateInscription(String stateInscription);

    String getObservations();

    void setObservations(String observations);

    String getGroupName();

    void setGroupName(String groupName);

    String getCompany();

    void setCompany(String company);

    boolean isForeignCustomer();

    void setForeignCustomer(boolean foreignCustomer);
}
