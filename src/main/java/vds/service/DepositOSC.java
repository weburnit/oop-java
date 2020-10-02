package vds.service;

import vds.api.Deposit;
import vds.api.interfaces.DepositRepoInterface;

import java.util.List;

public class DepositOSC implements DepositRepoInterface {
    @Override
    public Error Create(Deposit deposit) {
        return null;
    }

    @Override
    public List<Deposit> ListDeposit() {
        return null;
    }
}
