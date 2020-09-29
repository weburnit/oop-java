package vds.infrastructure.services;

import vds.api.interfaces.IUserMoneyAvailable;
import org.springframework.stereotype.Service;

@Service
public class UserMoneyAvailable implements IUserMoneyAvailable {
    @Override
    public boolean CheckMoneyAvailable(double availableMoney, double subMoney) {
        if (availableMoney < subMoney) {
            return false;
        }
        return true;
    }
}
