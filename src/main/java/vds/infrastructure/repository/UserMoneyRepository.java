package vds.infrastructure.repository;

import vds.api.interfaces.IUserMoneyRepo;
import vds.api.UserMoney;
import org.springframework.stereotype.Service;

@Service
public class UserMoneyRepository implements IUserMoneyRepo {
    @Override
    public UserMoney GetByID(int ID) {
        // Should use transaction
        UserMoney userMoney = UserMoney.Create(1, 500,400);
        return userMoney;
    }

    @Override
    public Error Update(UserMoney userMoney) {
        // Should use transaction
        return null;
    }
}
