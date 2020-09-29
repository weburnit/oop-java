package vds.api.interfaces;

import vds.api.UserMoney;

public interface IUserMoneyRepo {
    UserMoney GetByID(int ID);
    Error Update(UserMoney userMoney);
}
