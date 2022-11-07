package com.ruxx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Concepto 1: Como obtener Beans

        // Opcion 1. Crear un objeto de forma normal
        //Calculadora service = new Calculadora();

        // Opcion 2. Recibir un objeto de Spring
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");

        String texto = calculadora.holamundo();
        System.out.println(texto);

        // se puede volver a obetener
        // ojo se recuerpa el mismo objeto

        Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");
        texto = calculadora.holamundo();
        System.out.println(texto);

        // Concepto 2: cargar un bean dentro de otro bean

        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holamundo());

        // Concepto 3: scope o alcance. por defecto son SINGLETON.
        // podemos cambiarlo a scope="prototype" si queremos que se cree un objeto nuevo cada vez



    }
}
