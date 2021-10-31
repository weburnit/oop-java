package mck.service.pos;

import mck.dto.deposit.DepositFromMobileRequest;
import mck.dto.output.DepositResponse;
import mck.dto.output.TransferMoneyResponse;
import mck.dto.request.ActiveAccountRequest;
import mck.dto.request.DepositFromBankRequest;
import mck.dto.request.RegisterAccountRequest;
import mck.dto.request.TransferMoneyByMobileNumberRequest;
import mck.dto.transfer.MoneyByUserIDRequest;
import mck.spi.DigitalBankingService;
import mck.spi.DepositCredit;
import mck.spi.TransferCredit;

public class PosBankingService implements DigitalBankingService {
    DepositCredit depositCredit;
    TransferCredit transferCredit;
    DigitalBankingService provider;

    PosBankingService ( DepositCredit depositCredit, TransferCredit transferCredit, DigitalBankingService provider) {
        this.depositCredit = depositCredit;
        this.transferCredit = transferCredit;
        this.provider = provider;
    }

    @Override
    public DepositResponse DepositFromBank(int currentUser, DepositFromBankRequest request) {
        return this.depositCredit.DepositFromBank(currentUser, request);
    }

    @Override
    public DepositResponse DepositFromMobileCard(int currentUser, DepositFromMobileRequest request) {
        return this.depositCredit.DepositFromMobileCard(currentUser, request);
    }

    @Override
    public Error RegisterAccount(RegisterAccountRequest request) {
        //Implement its own RegisterAccount function
        return null;
    }

    @Override
    public Error ActiveAccount(ActiveAccountRequest request) {
        return this.provider.ActiveAccount(request);
    }

    @Override
    public TransferMoneyResponse TransferMoneyByUserID(int senderID, MoneyByUserIDRequest request) {
        return this.transferCredit.TransferMoneyByUserID(senderID, request);
    }

    @Override
    public TransferMoneyResponse TransferMoneyByMobileNumber(int senderID, TransferMoneyByMobileNumberRequest request) {
        return this.transferCredit.TransferMoneyByMobileNumber(senderID, request);
    }
}
