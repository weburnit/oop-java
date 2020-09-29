package vds.api.services;

import vds.api.interfaces.IProviderAccount;

public class MobileAccount implements IProviderAccount {
    public String MobileNumber;

    private MobileAccount(String mobileNumber){ this.MobileNumber = mobileNumber; }

    public static MobileAccount Create(String mobileNumber) {
        return new MobileAccount(mobileNumber);
    }

    @Override
    public Error Register() {
        // Send OTP
        return null;
    }

    @Override
    public Error ValidateAccount(String code) {
        // Validate OTP
        return null;
    }
}
