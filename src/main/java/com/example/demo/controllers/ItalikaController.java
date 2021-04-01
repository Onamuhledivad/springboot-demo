package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ItalikaModel;
import com.example.demo.services.ItalikaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class ItalikaController {

    @Autowired //Instancia al la clase de servicios
    ItalikaServices italikaService;

    //Rutas

    @GetMapping() //Peticion GET
    public ArrayList<ItalikaModel> obtenerProductos(){
        return this.italikaService.obtenerProductos();
    }

    @PostMapping //Peticion POST nuevo producto
    public ItalikaModel guardarProducto(@RequestBody ItalikaModel producto){
        return this.italikaService.nuevoProducto(producto);
    }

    @GetMapping(path = "/{id}") //Peticion GET por ID
    public Optional<ItalikaModel> obtenerporId(@PathVariable("id") Long id){
        return this.italikaService.buscarporID(id);
    }

    @GetMapping("/query") //Peticion GET por SKU y Modelo
    public ArrayList<ItalikaModel> obtenerporSKU(@RequestParam("tipo") String tipo, @RequestParam("buscar") String buscar){

        switch (tipo) {
            case "sku":
                return this.italikaService.buscarporSKU(buscar);
            case "modelo":
                return this.italikaService.buscarporModelo(buscar);
            default:
                return null;
        }
        
    }

    // @GetMapping("/query") //Peticion GET por Modelo
    // public Optional<ItalikaModel> obtenerporModelo(@RequestParam("modelo") String modelo){
    //     
    // }

    @DeleteMapping("/{id}") //Delete por ID
    public String eliminarporID(@PathVariable("id") Long id){
        boolean ok = this.italikaService.eliminarProducto(id);
        if(ok){
            return "Producto Eliminado";
        } else {
            return "Error al Eliminar Id: " + id;
        }
    }





    
}
