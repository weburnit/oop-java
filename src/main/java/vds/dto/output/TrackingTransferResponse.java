package vds.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackingTransferResponse {
    public int TrackingID;
    public int UserTransferID;
    public int UserReceiveID;
    public double MoneyTransfer;
    public int Status;
    public String Message;

    private TrackingTransferResponse (@JsonProperty("id") int id,@JsonProperty("userReceiveID") int userReceiveID,
                                      @JsonProperty("userTransferID") int userTransferID,@JsonProperty("moneyTransfer") double moneyTransfer,
                                      @JsonProperty("moneyTransfer") int status, @JsonProperty("message") String message) {
        this.TrackingID = id;
        this.UserReceiveID = userReceiveID;
        this.UserTransferID = userTransferID;
        this.MoneyTransfer = moneyTransfer;
        this.Status = status;
        this.Message = message;
    }

    public static TrackingTransferResponse Create(int id, int userReceiveID,int userTransferID,double moneyTransfer,int status, String message){
        return new TrackingTransferResponse(id,userReceiveID, userTransferID,moneyTransfer,status, message);
    }
}
