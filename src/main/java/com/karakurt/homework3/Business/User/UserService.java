package com.karakurt.homework3.Business.User;

import com.karakurt.homework3.DataAccess.User.IUserDao;
import com.karakurt.homework3.Entities.Address.IAddress;
import com.karakurt.homework3.Entities.User.IUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserDao iUserDao;

    @Override
    public List<IUser> getRandomUsers() {
        return this.iUserDao.getRandomUsers();
    }
    @Override
    public IUser createUser(String firstName, String lastName, String email, String address) {
        return this.iUserDao.createUser(firstName, lastName, email, address);
    }

    @Override
    public IUser updateUser(Long id, String firstName, String lastName, String email, String address) {
        return this.iUserDao.updateUser(id, firstName, lastName, email, address);
    }

    @Override
    public void deleteUser(Long id) {
        this.iUserDao.deleteUser(id);
    }
}
