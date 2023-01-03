package com.bolsadeideas.app.springbootweb.controllers;

import com.bolsadeideas.app.springbootweb.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexcontroller.perfil.titulo}")
    private String perfilIndex;
    @Value("${texto.indexcontroller.listar.titulo}")
    private String listarIndex;
    @GetMapping(value = {"/index", "", "/"})
    public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @GetMapping(value = "/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setApellido("blanco");
        usuario.setNombre("Leandro");
        usuario.setEmail("asdasd@asdasdasd.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", perfilIndex.concat(usuario.getNombre()));
        return "perfil";
    }

    @GetMapping(value = "/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", listarIndex);
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuario(){

        List<Usuario> usuarios = Arrays.asList(new Usuario("nombre1", "apellido1", "email1"),
                new Usuario("nombre2", "apellido2", "email2"),
                new Usuario("nombre3", "apellido3", "email3"));
        return usuarios;
    }

}
