package vds.service;

import vds.dto.deposit.DepositFromMobileRequest;
import vds.dto.output.DepositResponse;
import vds.dto.request.DepositFromBankRequest;
import vds.spi.DepositCredit;

public class DepositService implements DepositCredit {
    @Override
    public DepositResponse DepositFromBank(int currentUser, DepositFromBankRequest request) {
        return null;
    }

    @Override
    public DepositResponse DepositFromMobileCard(int currentUser, DepositFromMobileRequest request) {
        return null;
    }
}
