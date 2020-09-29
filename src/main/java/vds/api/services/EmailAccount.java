package vds.api.services;

import vds.api.interfaces.IProviderAccount;

public class EmailAccount implements IProviderAccount {
    public String Email;

    private EmailAccount(String email){ this.Email = email; }

    public static EmailAccount Create(String email) {
        return new EmailAccount(email);
    }

    @Override
    public Error Register() {
        // Send Email
        return null;
    }

    @Override
    public Error ValidateAccount(String code) {
        // Validate email code
        return null;
    }

}
