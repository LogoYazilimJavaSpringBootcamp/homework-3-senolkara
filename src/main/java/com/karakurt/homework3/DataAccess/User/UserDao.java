package com.karakurt.homework3.DataAccess.User;

import com.karakurt.homework3.DataAccess.Address.AddressDao;
import com.karakurt.homework3.Entities.Address.Address;
import com.karakurt.homework3.Entities.Address.AddressType;
import com.karakurt.homework3.Entities.User.IUser;
import com.karakurt.homework3.Entities.User.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements IUserDao {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.routing.name}")
    private String routingName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;
    public static List<IUser> randomUsers;

    private AddressDao addressDao = new AddressDao();;

    public UserDao(){
        if (randomUsers == null){
            List<IUser> userList = new ArrayList<>();
            List<IUser> randomUserList = createRandomUsers(userList);
            setRandomUsers(randomUserList);
        }
    }

    public List<IUser> createRandomUsers(List<IUser> randomUsers) {
        Address iAddress = addressDao.createAddress("London", AddressType.BILLING);
        randomUsers.add(new User(1L,"Tami","Benj","tamibenj@hotmail.com",iAddress));
        iAddress = addressDao.createAddress("Manchester", AddressType.BILLING);
        randomUsers.add(new User(2L,"Antonia","Cayley","antoniacayley@hotmail.com",iAddress));
        iAddress = addressDao.createAddress("Nottingham", AddressType.BILLING);
        randomUsers.add(new User(3L,"Kyleigh","Drummond","kyleighdrummond@hotmail.com",iAddress));
        iAddress = addressDao.createAddress("Norwich", AddressType.BILLING);
        randomUsers.add(new User(4L,"Sierra","Madeline","sierramadeline@hotmail.com",iAddress));
        iAddress = addressDao.createAddress("Aston", AddressType.BILLING);
        randomUsers.add(new User(5L,"Dillan","Steph","dillansteph@hotmail.com",iAddress));
        iAddress = addressDao.createAddress("Brighton", AddressType.BILLING);
        randomUsers.add(new User(6L,"Marlene","Hansen","marlenehansen@hotmail.com",iAddress));
        iAddress = addressDao.createAddress("Southampton", AddressType.BILLING);
        randomUsers.add(new User(7L,"Nellie","Schmidt","nellieschmidt@hotmail.com",iAddress));
        iAddress = addressDao.createAddress("Hull", AddressType.BILLING);
        randomUsers.add(new User(8L,"Jim","Hudson","jimhudson@hotmail.com",iAddress));
        iAddress = addressDao.createAddress("Fulham", AddressType.BILLING);
        randomUsers.add(new User(9L,"Aaron","Moore","aaronmoore@hotmail.com",iAddress));
        iAddress = addressDao.createAddress("Watford", AddressType.BILLING);
        randomUsers.add(new User(10L,"Leona","Flores","leonaflores@hotmail.com",iAddress));
        return randomUsers;
    }

    @Override
    public List<IUser> getRandomUsers() {
        return randomUsers;
    }

    @Override
    public IUser createUser(String firstName, String lastName, String email, String address) {
        Address iAddress = addressDao.createAddress(address, AddressType.BILLING);
        Long id = Long.valueOf(randomUsers.size() + 1);
        User iUser = new User(id, firstName, lastName, email, iAddress);
        randomUsers.add(iUser);

        System.out.println("User Sent ID : " + iUser.getId());
        this.rabbitTemplate.convertAndSend(exchangeName, routingName, iUser);

        return iUser;
    }

    @Override
    public IUser updateUser(Long id, String firstName, String lastName, String email, String address) {
        IUser iUser = randomUsers.get(Math.toIntExact(id - 1));
        iUser.setFirstName(firstName);
        iUser.setLastName(lastName);
        iUser.setEmail(email);
        iUser.setAddress(addressDao.createAddress(address, AddressType.BILLING));
        randomUsers.remove(Math.toIntExact(id - 1));
        randomUsers.add(Math.toIntExact(id - 1),iUser);
        return iUser;
    }

    @Override
    public void deleteUser(Long id) {
        randomUsers.remove(Math.toIntExact(id - 1));
    }

    public void setRandomUsers(List<IUser> randomUserList) {
        randomUsers = randomUserList;
    }


}
