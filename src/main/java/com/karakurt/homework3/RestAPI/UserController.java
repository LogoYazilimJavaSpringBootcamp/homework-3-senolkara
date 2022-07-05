package com.karakurt.homework3.RestAPI;

import com.karakurt.homework3.Business.User.IUserService;
import com.karakurt.homework3.Entities.User.IUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api")
@RequiredArgsConstructor
public class UserController {

    private final IUserService iUserService;

    @GetMapping
    public List<IUser> getUserList(){
        return this.iUserService.getRandomUsers();
    }

    @PostMapping
    public IUser createUser(String firstName, String lastName, String email, String address){
        return this.iUserService.createUser(firstName, lastName, email, address);
    }

    @PatchMapping("/{id}")
    public IUser updateUser(@PathVariable Long id, String firstName, String lastName, String email, String address){
        return this.iUserService.updateUser(id, firstName, lastName, email, address);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        this.iUserService.deleteUser(id);
    }
}
