package vds.api;

public class TrackingTransfer {

    public int TrackingID;
    public int UserTransferID;
    public int UserReceiveID;
    public double MoneyTransfer;
    public int Status;
    public String Message;

    private TrackingTransfer (int id, int userReceiveID, int userTransferID, double moneyTransfer) {
        this.TrackingID = id;
        this.UserReceiveID = userReceiveID;
        this.UserTransferID = userTransferID;
        this.MoneyTransfer = moneyTransfer;
    }

    public static TrackingTransfer Create (int userReceiveID, int userTransferID, double moneyTransfer) {
        return new TrackingTransfer(0, userReceiveID, userTransferID, moneyTransfer);
    }

    public static TrackingTransfer Create (int id, int userReceiveID, int userTransferID, double moneyTransfer) {
        return new TrackingTransfer(id, userReceiveID, userTransferID, moneyTransfer);
    }

    public TrackingTransfer WithStatus(int status)  {
        this.Status = status;
        return this;
    }

    public TrackingTransfer WithMessage(String message) {
        this.Message = message;
        return this;
    }


}
