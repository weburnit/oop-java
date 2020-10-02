package vds.service;

import org.springframework.stereotype.Service;

@Service
public class UserMoneyAvailable implements vds.api.interfaces.UserMoneyAvailableInterface {
    @Override
    public boolean CheckMoneyAvailable(double availableMoney, double subMoney) {
        if (availableMoney < subMoney) {
            return false;
        }
        return true;
    }
}
