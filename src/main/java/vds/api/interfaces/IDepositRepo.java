package vds.api.interfaces;

import vds.api.Deposit;

import java.util.List;

public interface IDepositRepo {
    Error Create(Deposit deposit);
    List<Deposit> ListDeposit();
}
