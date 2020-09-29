package vds.infrastructure.services;

import org.springframework.stereotype.Service;

@Service
public class UserMoneyAvailableInterface implements vds.api.interfaces.UserMoneyAvailableInterface {
    @Override
    public boolean CheckMoneyAvailable(double availableMoney, double subMoney) {
        if (availableMoney < subMoney) {
            return false;
        }
        return true;
    }
}
