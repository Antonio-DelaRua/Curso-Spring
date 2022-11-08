package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");


        NotificationService notificationService = (NotificationService) context.getBean("notificationService");
        String texto = notificationService.holaMundo();
        System.out.println(texto);



        UserService gestor = (UserService) context.getBean("userService");
        System.out.println(gestor.notificationService.holaMundo());



    }
}
