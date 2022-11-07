package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");


        Helloworld notificationService = (Helloworld) context.getBean("helloworld");
        String texto = notificationService.holaMundo();
        System.out.println(texto);






    }
}
