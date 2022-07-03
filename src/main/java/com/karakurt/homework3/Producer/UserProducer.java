package com.karakurt.homework3.Producer;

import com.karakurt.homework3.Entities.User.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

@Service
public class UserProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.routing.name}")
    private String routingName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init(){
        runSomething();
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 5000)
    public void runSomething(){
        Random random = new Random();
        int rand = random.nextInt(10000) + 5;
        User user = new User();
        user.setId(rand);
        user.setFirstName("senol");
        user.setLastName("karakurt");
        sendToQueue(user);
    }

    public void sendToQueue(User user) {
        System.out.println("User Sent ID : " + user.getId());
        rabbitTemplate.convertAndSend(exchangeName, routingName, user);
    }
}
