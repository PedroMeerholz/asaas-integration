package integration.asaas.request.assasresponse;

import java.util.ArrayList;
import java.util.List;

public class AsaasErrorList {
    private List<AsaasError> errors = new ArrayList<>();

    public List<AsaasError> getErrors() {
        return errors;
    }

    public void setErrors(List<AsaasError> errors) {
        this.errors = errors;
    }
}
