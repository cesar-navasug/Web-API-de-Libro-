package com.tuuniversidad.demo.controller;

import com.tuuniversidad.demo.models.Libro;
import com.tuuniversidad.demo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;
    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }
    @GetMapping
    public List<Libro> obtenerTodosLosLibros() {
        return libroService.obtenerTodosLosLibros();
    }
    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable Long id) {
        return libroService.obtenerLibroPorId(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }
    @PostMapping
    public String crearLibro(@RequestBody Libro libro) {
        libroService.agregarLibro(libro);
        return "Libro creado exitosamente.";
    }
}
