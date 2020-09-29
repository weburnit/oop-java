package vds.infrastructure.repository;

import vds.api.Deposit;
import vds.api.interfaces.IDepositRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
