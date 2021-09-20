package mck.spi;

import mck.dto.output.DepositResponse;
import mck.dto.request.DepositFromBankRequest;
import mck.dto.deposit.DepositFromMobileRequest;

public interface DepositCredit {
    DepositResponse DepositFromBank(int currentUser, DepositFromBankRequest request);

    DepositResponse DepositFromMobileCard(int currentUser, DepositFromMobileRequest request);
}
