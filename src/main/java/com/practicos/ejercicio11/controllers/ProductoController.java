package com.practicos.ejercicio11.controllers;

import com.practicos.ejercicio11.models.Producto;
import com.practicos.ejercicio11.repositories.ProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<Producto>> obtenerTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Producto> productosPaginados = productoRepository.findAll(pageable);

        return ResponseEntity.ok().body(productosPaginados);
    }

}
