package vds.spi;

import vds.dto.output.TransferMoneyResponse;
import vds.dto.request.TransferMoneyByMobileNumberRequest;
import vds.dto.transfer.MoneyByUserIDRequest;

public interface TransferCredit {
    TransferMoneyResponse TransferMoneyByUserID (int senderID, MoneyByUserIDRequest request);
    TransferMoneyResponse TransferMoneyByMobileNumber (int senderID, TransferMoneyByMobileNumberRequest request);
}
