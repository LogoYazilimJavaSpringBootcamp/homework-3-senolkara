package com.karakurt.homework3.Entities.User;

import java.io.Serializable;
import com.karakurt.homework3.Entities.Address.IAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements IUser, Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private IAddress iAddress;
}
