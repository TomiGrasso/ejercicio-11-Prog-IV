package com.practicos.ejercicio10.controllers;

import com.practicos.ejercicio10.models.Producto;
import com.practicos.ejercicio10.repositories.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @PostMapping
    public ResponseEntity<Producto> agregar (@RequestBody Producto producto){
        Producto p = productoRepository.save(producto);
        return ResponseEntity.ok(p);
    }

    @GetMapping
    public Iterable<Producto> obtenerTodos(){
        return productoRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Producto> obtenerPorId(@PathVariable Long id){
        return productoRepository.findById(id);
    }

}
