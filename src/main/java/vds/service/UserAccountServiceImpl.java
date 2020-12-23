package vds.service;

import vds.dto.deposit.DepositFromMobileRequest;
import vds.dto.request.*;
import vds.dto.output.DepositResponse;
import vds.dto.output.TransferMoneyResponse;
import vds.api.*;
import vds.api.interfaces.*;
import vds.dto.transfer.MoneyByUserIDRequest;
import vds.spi.DepositCredit;
import vds.spi.Publisher;
import vds.spi.TransferCredit;
import vds.spi.AccountService;

public class UserAccountServiceImpl implements AccountService {
    private UserAccountRepoInterface userAccountRepo;
    private UserMoneyRepoInterface userMoneyRepo;
    private UserMoneyAvailable userMoneyAvailable;
    private TrackingTransferRepoInterface trackingTransferRepo;
    private DepositRepoInterface depositRepo;
    private Publisher publisher;

    private DepositCredit depositDelegation;
    private TransferCredit transferCredit;

    public UserAccountServiceImpl(UserAccountRepoInterface userAccountRepo, TrackingTransferRepoInterface trackingTransferRepo,
                                  UserMoneyRepoInterface userMoneyRepo, UserMoneyAvailable userMoneyAvailable,
                                  DepositRepoInterface depositRepo, Publisher publisher, DepositCredit depositDelegation, TransferCredit transferCredit){
        this.userAccountRepo = userAccountRepo;
        this.userMoneyRepo = userMoneyRepo;
        this.userMoneyAvailable = userMoneyAvailable;
        this.trackingTransferRepo = trackingTransferRepo;
        this.publisher = publisher;
        this.depositRepo = depositRepo;
        this.depositDelegation = depositDelegation;
        this.transferCredit = transferCredit;
    }

    @Override
    public Error RegisterAccount(RegisterAccountRequest request) {
        UserAccount userAccount =  UserAccount.Create(request.MobileNumber).
                WithEmailProvider(request.Email);
        Error err = userAccount.Register();
        if ( err != null) {
            return err;
        }
        return userAccountRepo.Create(userAccount);
    }

    @Override
    public Error ActiveAccount(ActiveAccountRequest request) {
        UserAccount userAccount = userAccountRepo.GetByID(request.ID);
         userAccount.WithEmailProvider(userAccount.Email);
        Error err = userAccount.Active(request.Code);
        if ( err != null) {
            return err;
        }
        return userAccountRepo.Update(userAccount);
    }

    @Override
    public TransferMoneyResponse TransferMoneyByUserID(int senderID, MoneyByUserIDRequest request) {
        UserMoney sender = userMoneyRepo.GetByID(senderID).WithUserMoneyAvailable(userMoneyAvailable);
        UserMoney receiver = userMoneyRepo.GetByID(request.UserReceiveID);
        return transferMoney(senderID, receiver, request.MoneyNumber, sender);
    }

    @Override
    public TransferMoneyResponse TransferMoneyByMobileNumber(int senderID, TransferMoneyByMobileNumberRequest request) {
        UserMoney sender = userMoneyRepo.GetByID(senderID).WithUserMoneyAvailable(userMoneyAvailable);
        UserAccount userAccount = userAccountRepo.GetByMobileNumber(request.MobileNumber);
        UserMoney receiver = userMoneyRepo.GetByID(userAccount.UserID);
        return transferMoney(senderID, receiver, request.MoneyNumber, sender);
    }

    @Override
    public DepositResponse DepositFromBank(int currentUser, DepositFromBankRequest request) {
        return this.depositDelegation.DepositFromBank(currentUser, request);
    }

    @Override
    public DepositResponse DepositFromMobileCard(int currentUser, DepositFromMobileRequest request) {
        UserMoney userMoney = userMoneyRepo.GetByID(currentUser);
        Deposit deposit = Deposit.Create(currentUser).WithMobileProvider(request.Operator,request.CardNumber);
        return deposit(userMoney, deposit, request.MoneyNumber);
    }

    private DepositResponse deposit(UserMoney userMoney, Deposit deposit, double moneyNumber) {
        Error err = deposit.Deposit(moneyNumber);
        depositRepo.Create(deposit);
        if ( err != null ) {
            return DepositResponse.Create(userMoney.AvailableMoney, userMoney.BeforeMoney, deposit.Status,deposit.Message);
        }
        userMoney.DepositMoney(moneyNumber);
        userMoneyRepo.Update(userMoney);
        return DepositResponse.Create(userMoney.AvailableMoney, userMoney.BeforeMoney, deposit.Status,deposit.Message);
    }

    private TransferMoneyResponse transferMoney(int senderID, UserMoney receiver, double moneyNumber, UserMoney sender) {
        TransferMoneyResponse response;
        TrackingTransfer trackingTransfer;

        Error err = sender.CalculateSubMoney(moneyNumber);
        if ( err != null) {
            trackingTransferRepo.Create(TrackingTransfer.Create(receiver.UserID, senderID, moneyNumber).WithStatus(TrackingStatus.StatusFail));
            return TransferMoneyResponse.Create(sender.AvailableMoney, sender.BeforeMoney, TrackingStatus.StatusFail, err.getMessage());
        }
        try {
            receiver.DepositMoney(moneyNumber);
            //should use transaction
            userMoneyRepo.Update(sender);
            userMoneyRepo.Update(receiver);
            trackingTransfer = TrackingTransfer.Create(receiver.UserID, senderID, moneyNumber).WithStatus(TrackingStatus.StatusSuccess);
            response = TransferMoneyResponse.Create(sender.AvailableMoney, sender.BeforeMoney, TrackingStatus.StatusSuccess, "");

            //Send Email or Mobile
            publisher.Publish(trackingTransfer);
        } catch (Exception e) {
            trackingTransfer = TrackingTransfer.Create(receiver.UserID, senderID, moneyNumber).WithStatus(TrackingStatus.StatusFail);
            response = TransferMoneyResponse.Create(sender.AvailableMoney, sender.BeforeMoney, TrackingStatus.StatusFail, e.getMessage());
        }
        trackingTransferRepo.Create(trackingTransfer);
        return response;
    }


}
