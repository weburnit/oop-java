package mck.api.model;

import mck.api.interfaces.ProviderAccountInterface;

public class EmailAccount implements ProviderAccountInterface {
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
