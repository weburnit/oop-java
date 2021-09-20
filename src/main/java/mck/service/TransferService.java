package mck.service;

import mck.dto.output.TransferMoneyResponse;
import mck.dto.request.TransferMoneyByMobileNumberRequest;
import mck.dto.transfer.MoneyByUserIDRequest;
import mck.spi.TransferCredit;

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
