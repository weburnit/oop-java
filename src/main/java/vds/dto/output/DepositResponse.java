package vds.dto.output;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositResponse {

    public double AvailableMoney;
    public double BeforeMoney;
    public int Status;
    public String Message;

    @JsonCreator
    private DepositResponse(@JsonProperty("availableMoney") double availableMoney, @JsonProperty("beforeMoney") double beforeMoney,
                                  @JsonProperty("status") int status, @JsonProperty("message") String message) {
        this.AvailableMoney = availableMoney;
        this.BeforeMoney = beforeMoney;
        this.Status = status;
        this.Message = message;
    }

    public static DepositResponse Create(double availableMoney, double beforeMoney, int status, String message){
        return new DepositResponse(availableMoney,beforeMoney,status, message);
    }
}
