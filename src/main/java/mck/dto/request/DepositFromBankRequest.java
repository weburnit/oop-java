package mck.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositFromBankRequest {
    public double MoneyNumber;
    public String Operator;
    public String CardNumber;
    public int SecretCode;


    @JsonCreator
    private DepositFromBankRequest(@JsonProperty("moneyNumber") double moneyNumber, @JsonProperty("Operator") String operator,
                                   @JsonProperty("cardNumber") String cardNumber, @JsonProperty("secretCode") int secretCode) {
        this.Operator = operator;
        this.MoneyNumber = moneyNumber;
        this.CardNumber = cardNumber;
        this.SecretCode = secretCode;
    }

    public static DepositFromBankRequest Create(double moneyNumber, String operator, String cardNumber, int secretCode){
        return new DepositFromBankRequest(moneyNumber,operator,cardNumber,secretCode);
    }
}
