package vds.api;

import vds.api.interfaces.UserMoneyAvailableInterface;

public class UserMoney {
    private UserMoneyAvailableInterface userMoneyAvailable;

    public int UserID;
    public double AvailableMoney;
    public double BeforeMoney;

    private UserMoney(int userID, double availableMoney, double beforeMoney){
        this.UserID = userID;
        this.AvailableMoney = availableMoney;
        this.BeforeMoney = beforeMoney;
    }

    public static UserMoney Create(int userID, double availableMoney, double beforeMoney){
        return new UserMoney(userID,availableMoney,beforeMoney);
    }

    public UserMoney WithUserMoneyAvailable (UserMoneyAvailableInterface userMoneyAvailable) {
        this.userMoneyAvailable = userMoneyAvailable;
        return this;
    }

    public Error CalculateSubMoney(double expectSubMoney){
        if (userMoneyAvailable.CheckMoneyAvailable(AvailableMoney,expectSubMoney)){
            return new Error("don't enough to send money for other user");
        }
        BeforeMoney = AvailableMoney;
        AvailableMoney -= expectSubMoney;
        return null;
    }


    public void DepositMoney(double money){
        BeforeMoney = AvailableMoney;
        AvailableMoney += money;
    }

}
