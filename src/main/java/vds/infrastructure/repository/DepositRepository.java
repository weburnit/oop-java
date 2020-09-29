package vds.infrastructure.repository;

import vds.api.Deposit;
import vds.api.interfaces.IDepositRepo;

import java.util.List;

public class DepositRepository implements IDepositRepo {
    @Override
    public Error Create(Deposit deposit) {
        return null;
    }

    @Override
    public List<Deposit> ListDeposit() {
        return null;
    }
}
