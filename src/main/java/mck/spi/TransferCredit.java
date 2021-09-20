package mck.spi;

import mck.dto.output.TransferMoneyResponse;
import mck.dto.request.TransferMoneyByMobileNumberRequest;
import mck.dto.transfer.MoneyByUserIDRequest;

public interface TransferCredit {
    TransferMoneyResponse TransferMoneyByUserID (int senderID, MoneyByUserIDRequest request);
    TransferMoneyResponse TransferMoneyByMobileNumber (int senderID, TransferMoneyByMobileNumberRequest request);
}
