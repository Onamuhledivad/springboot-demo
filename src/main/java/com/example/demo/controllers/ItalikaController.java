package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ItalikaModel;
import com.example.demo.services.ItalikaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return this.italikaService.obtenerProductosService();
    }

    @PostMapping() //Peticion POST nuevo producto
    public ResponseEntity<String> insertProducto(@RequestBody ItalikaModel data){
       italikaService.nuevoProductoService(data);  
       return new ResponseEntity<>("Nuevo Producto Guardado", HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}") //Peticion GET por ID
    public Optional<ItalikaModel> obtenerporId(@PathVariable("id") Long id){
        return this.italikaService.buscarporIdService(id);
    }

    @GetMapping("/query") //Peticion GET por SKU y Modelo
    public ArrayList<ItalikaModel> buscarProducto(@RequestParam("tipo") String tipo, @RequestParam("buscar") String buscar){

        switch (tipo) {
            case "sku":
                return this.italikaService.buscarporSkuService(buscar);
            case "modelo":
                return this.italikaService.buscarporModeloService(buscar);
            default:
                return null;
        }
        
    }


    @DeleteMapping("/{id}") //Delete por ID
    public ResponseEntity<String> eliminarporID(@PathVariable("id") Long id){
        italikaService.eliminarProductoService(id);
        return new ResponseEntity<>("Producto Eliminado Correctamente", HttpStatus.OK);
    }





    
}
