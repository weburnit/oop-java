package vds.api.interfaces;

public interface IProviderAccount {
    Error Register();
    Error ValidateAccount(String code);
}
