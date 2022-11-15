package com.ruxx.cursoudemy.controller;

import com.ruxx.cursoudemy.models.Usuario;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/app/")
public class IndexController {

    @GetMapping({"/index", "/","", "/home"})
    public String index(Model model){
        model.addAttribute("titulo", "Hola, Antonio Delarua" );
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil (Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Antonio");
        usuario.setApellido("DelaRua");
        usuario.setEmail("delarua@gmail.com");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario".concat(usuario.getNombre()));

        return "perfil";
    }

    @GetMapping("/listar")
    public String listar (Model model){



        model.addAttribute("titulo", "Listado de usuarios");


        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(new Usuario("Antonio", "DelaRua", "delarua@gmail.com"),
                new Usuario("Danny", "Bombastic", "danny@gmail.com"),
                new Usuario("Juan", "Snow", "wan@gmail.com"),
                new Usuario("tornado", "Roe", "rie@gmail.com"));

        return usuarios;
    }

}
