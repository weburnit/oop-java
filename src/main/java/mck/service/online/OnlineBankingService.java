package mck.service.online;

import mck.dto.deposit.DepositFromMobileRequest;
import mck.dto.output.DepositResponse;
import mck.dto.output.TransferMoneyResponse;
import mck.dto.request.ActiveAccountRequest;
import mck.dto.request.DepositFromBankRequest;
import mck.dto.request.RegisterAccountRequest;
import mck.dto.request.TransferMoneyByMobileNumberRequest;
import mck.dto.transfer.MoneyByUserIDRequest;
import mck.infrastructure.events.Publisher;
import mck.spi.DigitalBankingService;
import mck.spi.DepositCredit;
import mck.spi.TransferCredit;

public class OnlineBankingService implements DigitalBankingService {
    DepositCredit depositServiceDelegation;
    TransferCredit transferServiceDelegation;

    Publisher pubsub;

    public OnlineBankingService(DepositCredit depositServiceDelegation, TransferCredit transferServiceDelegation, Publisher pubsub) {
        this.depositServiceDelegation = depositServiceDelegation;
        this.transferServiceDelegation = transferServiceDelegation;
        this.pubsub = pubsub;
    }

    @Override
    public Error RegisterAccount(RegisterAccountRequest request) {
        return null;
    }

    @Override
    public Error ActiveAccount(ActiveAccountRequest request) {
        return null;
    }

    @Override
    public DepositResponse DepositFromBank(int currentUser, DepositFromBankRequest request) {
        return null;
    }

    @Override
    public DepositResponse DepositFromMobileCard(int currentUser, DepositFromMobileRequest request) {
        return null;
    }

    @Override
    public TransferMoneyResponse TransferMoneyByUserID(int senderID, MoneyByUserIDRequest request) {
        return null;
    }

    @Override
    public TransferMoneyResponse TransferMoneyByMobileNumber(int senderID, TransferMoneyByMobileNumberRequest request) {
        return null;
    }
}
