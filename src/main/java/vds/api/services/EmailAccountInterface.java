package vds.api.services;

import vds.api.interfaces.ProviderAccountInterface;

public class EmailAccountInterface implements ProviderAccountInterface {
    public String Email;

    private EmailAccountInterface(String email){ this.Email = email; }

    public static EmailAccountInterface Create(String email) {
        return new EmailAccountInterface(email);
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
