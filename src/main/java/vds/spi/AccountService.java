package vds.spi;

import vds.dto.request.*;

public interface AccountService extends DepositCredit, TransferCredit {
    Error RegisterAccount(RegisterAccountRequest request);

    Error ActiveAccount(ActiveAccountRequest request);
}
