package vds.api;

import vds.api.interfaces.ProviderAccountInterface;
import vds.api.services.EmailAccount;
import vds.api.services.MobileAccount;

public class UserAccount {
    private ProviderAccountInterface providerAccount;

    //should use UUID
    public int UserID;
    public String MobileNUmber;
    public String Email;
    public int Status;

    private UserAccount(ProviderAccountInterface providerAccount, String mobileNUmber){
       this.providerAccount = providerAccount;
       this.MobileNUmber = mobileNUmber;
    }

    public static UserAccount Create(String mobileNUmber) {
        ProviderAccountInterface mobileAccount = MobileAccount.Create(mobileNUmber);
        return new UserAccount(mobileAccount,mobileNUmber);
    }

    public Error Register() {
        this.Status = UserStatus.StatusPending;
        Error err = providerAccount.Register();
        if ( err != null) {
            this.Status = UserStatus.StatusFail;
            return err;
        }
        return null;
    }

    public Error Active(String code) {
        this.Status = UserStatus.StatusSuccess;
        Error err = providerAccount.ValidateAccount(code);
        if ( err != null) {
            this.Status = UserStatus.StatusFail;
            return err;
        }
        return null;
    }

    public UserAccount WithEmailProvider(String email) {
        if (email == "") {
           return this;
        }
        ProviderAccountInterface emailAccount = EmailAccount.Create(email);
        this.Email = email;
        return this;
    }

}
