package com.karakurt.homework3.Business.User;

import com.karakurt.homework3.Entities.User.IUser;

import java.util.List;

public interface IUserService {
    List<IUser> getRandomUsers();
    IUser createUser(String firstName, String lastName, String email, String address);
    IUser updateUser(Integer id, String firstName, String lastName, String email, String address);
    void deleteUser(Integer id);
}
