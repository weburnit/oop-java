package mck.spi;

import mck.dto.request.*;

public interface DigitalBankingService extends DepositCredit, TransferCredit {
    Error RegisterAccount(RegisterAccountRequest request);

    Error ActiveAccount(ActiveAccountRequest request);
}
