package vds.spi;

import vds.dto.request.*;

public interface AccountServiceInterface extends DepositCreditInterface, TransferCreditInterface {
    Error RegisterAccount(RegisterAccountRequest request);

    Error ActiveAccount(ActiveAccountRequest request);
}
