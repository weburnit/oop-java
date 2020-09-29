package vds.dto.transfer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyByUserIDRequest {
    public int UserReceiveID;
    public double MoneyNumber;

    @JsonCreator
    private MoneyByUserIDRequest(@JsonProperty("id") int userReceiveID, @JsonProperty("moneyNumber") double moneyNumber) {
        this.MoneyNumber = moneyNumber;
        this.UserReceiveID = userReceiveID;
    }

    public static MoneyByUserIDRequest Create(int userReceiveID, double moneyNumber){
        return new MoneyByUserIDRequest(userReceiveID,moneyNumber);
    }
}
