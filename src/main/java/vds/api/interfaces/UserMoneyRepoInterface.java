package vds.api.interfaces;

import vds.api.UserMoney;

public interface UserMoneyRepoInterface {
    UserMoney GetByID(int ID);
    Error Update(UserMoney userMoney);
}
