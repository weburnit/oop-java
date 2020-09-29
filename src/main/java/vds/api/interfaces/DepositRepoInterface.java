package vds.api.interfaces;

import vds.api.Deposit;

import java.util.List;

public interface DepositRepoInterface {
    Error Create(Deposit deposit);
    List<Deposit> ListDeposit();
}
