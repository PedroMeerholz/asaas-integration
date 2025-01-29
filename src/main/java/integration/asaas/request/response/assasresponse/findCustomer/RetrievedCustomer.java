package integration.asaas.request.response.assasresponse.findCustomer;

import integration.asaas.api.model.customer.Customer;

public class RetrievedCustomer extends Customer {
    private String object;
    private String id;
    private String dateCreated;
    private boolean deleted;
    private String personType;
    private boolean canDelete;
    private String cannotBeDeletedReason;
    private boolean canEdit;
    private String cannotEditReason;
    private int city;
    private String cityName;
    private String state;
    private String country;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public String getCannotBeDeletedReason() {
        return cannotBeDeletedReason;
    }

    public void setCannotBeDeletedReason(String cannotBeDeletedReason) {
        this.cannotBeDeletedReason = cannotBeDeletedReason;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public String getCannotEditReason() {
        return cannotEditReason;
    }

    public void setCannotEditReason(String cannotEditReason) {
        this.cannotEditReason = cannotEditReason;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
