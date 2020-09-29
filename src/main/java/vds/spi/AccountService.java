package vds.spi;

import vds.dto.request.*;
import vds.dto.output.DepositResponse;
import vds.dto.output.TransferMoneyResponse;
import vds.dto.transfer.MoneyByUserIDRequest;

public interface AccountService extends DepositCredit, TransferCredit {
    Error RegisterAccount(RegisterAccountRequest request);

    Error ActiveAccount(ActiveAccountRequest request);
}
