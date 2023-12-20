
package com.sweetcherrytech.test.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.data.domain.Page; 
import org.springframework.data.domain.Pageable; 
import com.sweetcherrytech.test.domain.Producto;
import com.sweetcherrytech.test.repository.ProductoRepository;


@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto obtenerProductoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public Page<Producto> listarTodosLosProductos(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public long contarProductos() {
        return productoRepository.count();
    }
}
