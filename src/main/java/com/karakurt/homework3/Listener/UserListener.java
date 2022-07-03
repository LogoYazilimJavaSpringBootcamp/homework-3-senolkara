package com.karakurt.homework3.Listener;

import com.karakurt.homework3.Entities.User.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserListener {
    @RabbitListener(queues = "isbasi.email")
    public void handleMessage(User user){
        System.out.println("call received..");
        System.out.println(user.toString());
    }
}
