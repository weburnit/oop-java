package vds.service;

import vds.dto.output.TransferMoneyResponse;
import vds.dto.request.TransferMoneyByMobileNumberRequest;
import vds.dto.transfer.MoneyByUserIDRequest;
import vds.spi.TransferCredit;

public class TransferService implements TransferCredit {
    @Override
    public TransferMoneyResponse TransferMoneyByUserID(int senderID, MoneyByUserIDRequest request) {
        return null;
    }

    @Override
    public TransferMoneyResponse TransferMoneyByMobileNumber(int senderID, TransferMoneyByMobileNumberRequest request) {
        return null;
    }
}
