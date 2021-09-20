package mck.service;

import mck.dto.deposit.DepositFromMobileRequest;
import mck.dto.output.DepositResponse;
import mck.dto.request.DepositFromBankRequest;
import mck.spi.DepositCredit;

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
