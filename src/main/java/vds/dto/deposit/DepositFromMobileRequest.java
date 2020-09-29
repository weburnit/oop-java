package vds.dto.deposit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositFromMobileRequest {
    public double MoneyNumber;
    public String Operator;
    public String CardNumber;


    @JsonCreator
    private DepositFromMobileRequest(@JsonProperty("moneyNumber") double moneyNumber, @JsonProperty("Operator") String operator,
                                   @JsonProperty("cardNumber") String cardNumber) {
        this.Operator = operator;
        this.MoneyNumber = moneyNumber;
        this.CardNumber = cardNumber;
    }

    public static DepositFromMobileRequest Create(double moneyNumber, String operator, String cardNumber){
        return new DepositFromMobileRequest(moneyNumber,operator,cardNumber);
    }
}
