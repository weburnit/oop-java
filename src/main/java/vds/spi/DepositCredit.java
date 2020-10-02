package vds.spi;

import vds.dto.output.DepositResponse;
import vds.dto.request.DepositFromBankRequest;
import vds.dto.deposit.DepositFromMobileRequest;

public interface DepositCredit {
    DepositResponse DepositFromBank(int currentUser, DepositFromBankRequest request);

    DepositResponse DepositFromMobileCard(int currentUser, DepositFromMobileRequest request);
}
