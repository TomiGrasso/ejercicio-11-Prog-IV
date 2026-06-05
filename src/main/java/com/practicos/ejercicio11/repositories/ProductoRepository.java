package com.practicos.ejercicio11.repositories;

import com.practicos.ejercicio11.models.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>, CrudRepository<Producto, Long> {
}
