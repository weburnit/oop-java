package mck.api.interfaces;

public interface ProviderAccountInterface {
    Error Register();
    Error ValidateAccount(String code);
}
