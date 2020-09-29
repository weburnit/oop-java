package vds.api.interfaces;

import vds.api.UserAccount;

public interface UserAccountRepoInterface {
     Error Create(UserAccount userAccount);
     Error Update(UserAccount userAccount);
     UserAccount GetByID(int ID);
     UserAccount GetByMobileNumber(String mobileNumber);
}
