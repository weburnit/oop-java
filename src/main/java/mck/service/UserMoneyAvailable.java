package mck.service;

import org.springframework.stereotype.Service;

@Service
public class UserMoneyAvailable implements mck.api.interfaces.UserMoneyAvailableInterface {
    @Override
    public boolean CheckMoneyAvailable(double availableMoney, double subMoney) {
        if (availableMoney < subMoney) {
            return false;
        }
        return true;
    }
}
