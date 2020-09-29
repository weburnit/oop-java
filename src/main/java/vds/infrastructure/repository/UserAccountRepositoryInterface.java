package vds.infrastructure.repository;

import vds.api.interfaces.UserAccountRepoInterface;
import vds.api.UserAccount;
import org.springframework.stereotype.Service;

@Service
public class UserAccountRepositoryInterface implements UserAccountRepoInterface {

    @Override
    public Error Create(vds.api.UserAccount userAccount) {
        return null;
    }

    @Override
    public Error Update(vds.api.UserAccount userAccount) {
        return null;
    }

    @Override
    public vds.api.UserAccount GetByID(int ID) {
        //Get by database
        UserAccount userAccount = UserAccount.Create("0969837784");
        userAccount.UserID = 1;
        return userAccount;
    }

    @Override
    public UserAccount GetByMobileNumber(String mobileNumber) {
        //Get by database
        UserAccount userAccount = UserAccount.Create("0969837784");
        userAccount.UserID = 1;
        return userAccount;
    }
}
