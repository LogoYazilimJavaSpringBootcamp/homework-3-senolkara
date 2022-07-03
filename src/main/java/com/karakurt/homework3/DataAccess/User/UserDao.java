package com.karakurt.homework3.DataAccess.User;

import com.karakurt.homework3.DataAccess.Address.AddressDao;
import com.karakurt.homework3.Entities.Address.AddressType;
import com.karakurt.homework3.Entities.Address.IAddress;
import com.karakurt.homework3.Entities.User.IUser;
import com.karakurt.homework3.Entities.User.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements IUserDao {

    public static List<IUser> randomUsers;

    public UserDao(){
        if (randomUsers == null){
            List<IUser> userList = new ArrayList<>();
            List<IUser> randomUserList = createRandomUsers(userList);
            setRandomUsers(randomUserList);
        }
    }

    public List<IUser> createRandomUsers(List<IUser> randomUsers) {
        IAddress iAddress = createAddress("London");
        randomUsers.add(new User(1,"Tami","Benj","tamibenj@hotmail.com",iAddress));
        iAddress = createAddress("Manchester");
        randomUsers.add(new User(2,"Antonia","Cayley","antoniacayley@hotmail.com",iAddress));
        iAddress = createAddress("Nottingham");
        randomUsers.add(new User(3,"Kyleigh","Drummond","kyleighdrummond@hotmail.com",iAddress));
        iAddress = createAddress("Norwich");
        randomUsers.add(new User(4,"Sierra","Madeline","sierramadeline@hotmail.com",iAddress));
        iAddress = createAddress("Aston");
        randomUsers.add(new User(5,"Dillan","Steph","dillansteph@hotmail.com",iAddress));
        iAddress = createAddress("Brighton");
        randomUsers.add(new User(6,"Marlene","Hansen","marlenehansen@hotmail.com",iAddress));
        iAddress = createAddress("Southampton");
        randomUsers.add(new User(7,"Nellie","Schmidt","nellieschmidt@hotmail.com",iAddress));
        iAddress = createAddress("Hull");
        randomUsers.add(new User(8,"Jim","Hudson","jimhudson@hotmail.com",iAddress));
        iAddress = createAddress("Fulham");
        randomUsers.add(new User(9,"Aaron","Moore","aaronmoore@hotmail.com",iAddress));
        iAddress = createAddress("Watford");
        randomUsers.add(new User(10,"Leona","Flores","leonaflores@hotmail.com",iAddress));
        return randomUsers;
    }

    @Override
    public List<IUser> getRandomUsers() {
        return randomUsers;
    }

    @Override
    public IUser createUser(String firstName, String lastName, String email, String address) {
        IAddress iAddress = createAddress(address);
        Integer id = randomUsers.size() + 1;
        IUser iUser = new User(id, firstName, lastName, email, iAddress);
        randomUsers.add(iUser);
        return iUser;
    }

    @Override
    public IUser updateUser(Integer id, String firstName, String lastName, String email, String address) {
        IUser iUser = randomUsers.get(id - 1);
        iUser.setFirstName(firstName);
        iUser.setLastName(lastName);
        iUser.setEmail(email);
        iUser.setIAddress(createAddress(address));
        randomUsers.remove(id - 1);
        randomUsers.add(id - 1,iUser);
        return iUser;
    }

    @Override
    public void deleteUser(Integer id) {
        randomUsers.remove(id - 1);
    }

    public void setRandomUsers(List<IUser> randomUserList) {
        randomUsers = randomUserList;
    }

    public IAddress createAddress(String address){
        AddressDao addressDao = new AddressDao();
        IAddress iAddress = addressDao.createAddress(address, AddressType.BILLING);
        return iAddress;
    }
}
