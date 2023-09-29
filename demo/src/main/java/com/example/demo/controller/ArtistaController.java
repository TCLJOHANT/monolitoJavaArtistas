package com.example.demo.controller;
import com.example.demo.model.Artista;
import com.example.demo.model.ArtistaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class ArtistaController {
    private final ArtistaRepository artistaRepository;
    public ArtistaController(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }
    //LEER
    @GetMapping("/")
    public String index(Model model) {
        Iterable<Artista> artistas = artistaRepository.findAll();
        model.addAttribute("artistas", artistas);
        return "index";
    }
    //CREAR
    @PostMapping("/crear-artista")
    public String crearArtista(@ModelAttribute("artista") Artista artista) {
        artistaRepository.save(artista);
        return "redirect:/";
    }
    //ELiminar
    @GetMapping("/eliminar/{id}")
    public String eliminarArtista(@PathVariable("id") Long id) {
        artistaRepository.deleteById(id);
        return "redirect:/";
    }
    //traer un ARTISTA
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
        Artista artista = artistaRepository.findById(id).orElse(null);
        model.addAttribute("artista", artista);
        return "form/edicion";
    }
    //Editar Artista
    @PostMapping("/editar/{id}")
    public String guardarEdicion(@PathVariable("id") Long id, @ModelAttribute("artista") Artista artista) {
        artista.setId(id);
        artistaRepository.save(artista);
        return "redirect:/";
    }
}
