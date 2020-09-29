package vds.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferMoneyByMobileNumberRequest {
    public double MoneyNumber;
    public String MobileNumber;

    @JsonCreator
    private TransferMoneyByMobileNumberRequest(@JsonProperty("moneyNumber") double moneyNumber, @JsonProperty("mobileNumber") String mobileNumber) {
        this.MobileNumber = mobileNumber;
        this.MoneyNumber = moneyNumber;
    }

    public static TransferMoneyByMobileNumberRequest Create(double moneyNumber, String mobileNumber){
        return new TransferMoneyByMobileNumberRequest(moneyNumber,mobileNumber);
    }
}
