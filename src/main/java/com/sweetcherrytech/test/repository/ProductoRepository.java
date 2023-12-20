package com.sweetcherrytech.test.repository;

import com.sweetcherrytech.test.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByTituloContaining(String titulo);
    List<Producto> findByPrecioBetween(Double precioMinimo, Double precioMaximo);
    List<Producto> findBySku(String sku);
}
