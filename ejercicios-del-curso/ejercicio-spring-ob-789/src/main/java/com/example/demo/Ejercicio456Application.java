package com.example.demo;

import com.example.demo.entity.Laptop;
import com.example.demo.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio456Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);



	Laptop laptop1 = new Laptop(null,"apple",899.99,true);
	repository.save(laptop1);

		System.out.println("Num Laptos en base de datos : " + repository.findAll().size());


	}
}
