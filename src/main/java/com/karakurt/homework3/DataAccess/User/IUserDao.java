package com.karakurt.homework3.DataAccess.User;

import com.karakurt.homework3.Entities.Address.IAddress;
import com.karakurt.homework3.Entities.User.IUser;

import java.util.List;

public interface IUserDao {
    List<IUser> getRandomUsers();
    IUser createUser(String firstName, String lastName, String email, String address);
    IUser updateUser(Integer id, String firstName, String lastName, String email, String address);
    void deleteUser(Integer id);
}
