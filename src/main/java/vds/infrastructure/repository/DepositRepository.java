package vds.infrastructure.repository;

import vds.api.Deposit;
import vds.api.interfaces.DepositRepoInterface;

import java.util.List;

public class DepositRepository implements DepositRepoInterface {
    @Override
    public Error Create(Deposit deposit) {
        return null;
    }

    @Override
    public List<Deposit> ListDeposit() {
        return null;
    }
}
