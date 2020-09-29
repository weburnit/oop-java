package vds.infrastructure.repository;

import vds.api.Deposit;
import vds.api.interfaces.DepositRepoInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositRepositoryInterface implements DepositRepoInterface {
    @Override
    public Error Create(Deposit deposit) {
        return null;
    }

    @Override
    public List<Deposit> ListDeposit() {
        return null;
    }
}
