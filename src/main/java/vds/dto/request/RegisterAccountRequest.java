package vds.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterAccountRequest {
    public String MobileNumber;
    public String Email;

    @JsonCreator
    private RegisterAccountRequest(@JsonProperty("mobileNumber") String mobileNumber, @JsonProperty("email") String email) {
        this.MobileNumber = mobileNumber;
        this.Email = email;
    }

    public static RegisterAccountRequest Create(String mobileNumber, String email){
        return new RegisterAccountRequest(mobileNumber,email);
    }
}
