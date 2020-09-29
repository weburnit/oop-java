package vds.api.services;

import vds.api.interfaces.ProviderAccountInterface;

public class MobileAccountInterface implements ProviderAccountInterface {
    public String MobileNumber;

    private MobileAccountInterface(String mobileNumber){ this.MobileNumber = mobileNumber; }

    public static MobileAccountInterface Create(String mobileNumber) {
        return new MobileAccountInterface(mobileNumber);
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
