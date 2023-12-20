package com.sweetcherrytech.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sweetcherrytech.test.domain.Producto;
import com.sweetcherrytech.test.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.*;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductoControllerTest {

    @Mock
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productoController).build();
    }

    @Test
    public void testCrearProducto() throws Exception {
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setTitulo("Producto Test");

        when(productoService.saveProducto(any(Producto.class))).thenReturn(producto);

        mockMvc.perform(post("/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(producto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Producto Test"));
    }

    @Test
    public void testObtenerProductoPorId() throws Exception {
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setTitulo("Producto Test");

        when(productoService.obtenerProductoPorId(1L)).thenReturn(producto);

        mockMvc.perform(get("/productos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Producto Test"));
    }

    @Test
    public void testActualizarProducto() throws Exception {
        Producto productoExistente = new Producto();
        productoExistente.setId(1L);
        productoExistente.setTitulo("Producto Existente");

        Producto productoActualizado = new Producto();
        productoActualizado.setId(1L);
        productoActualizado.setTitulo("Producto Actualizado");

        when(productoService.obtenerProductoPorId(1L)).thenReturn(productoExistente);
        when(productoService.saveProducto(any(Producto.class))).thenReturn(productoActualizado);

        mockMvc.perform(put("/productos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(productoActualizado)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Producto Actualizado"));
    }

    @Test
    public void testEliminarProducto() throws Exception {
        Producto producto = new Producto();
        producto.setId(1L);

        // Ajustar la configuración del mock para que devuelva un producto directamente
        when(productoService.obtenerProductoPorId(1L)).thenReturn(producto);
        doNothing().when(productoService).eliminarProducto(1L);

        mockMvc.perform(delete("/productos/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testContarProductos() throws Exception {
        when(productoService.contarProductos()).thenReturn(10L);

        mockMvc.perform(get("/productos/count"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

}
