package vds.api.model;

import vds.api.interfaces.ProviderTransferInterface;

public class BankTransferService implements ProviderTransferInterface {
    public String Operator;
    public String CardNumber;
    public String CardNumberSecret;
    public int SecretCode;

    public interface TransferProtocol {
        void write(Object me);
    }

    public interface WireTransferInterface {
        void transferCredit(BankTransferDTO req, TransferProtocol protocol);
    }

    private WireTransferInterface delegationWireTransfer;

    private BankTransferService(String operator,
                                String cardNumber,
                                int secretCode,
                                WireTransferInterface delegationWireTransfer){
        this.Operator = operator;
        this.CardNumber = cardNumber;
        this.SecretCode = secretCode;
        this.delegationWireTransfer = delegationWireTransfer;
    }

    public static BankTransferService Create(String operator, String cardNumber, int secretCode) {
        return new BankTransferService(operator, cardNumber, secretCode, null);
    }

    @Override
    public Error DepositMoney(double money) {
        // Should delegate with bank operator

        //Get from bank
        this.CardNumberSecret = "429xxxxxxxx1123";
//        this.delegationWireTransfer.transferCredit(new BankTransferDTO());
        return null;
    }

    @Override
    public String GetCardNumberSecret() {
        return this.CardNumberSecret;
    }
}
