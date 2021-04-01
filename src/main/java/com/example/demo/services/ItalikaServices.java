package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ItalikaModel;
import com.example.demo.repositories.ItalikaRepository;

import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItalikaServices {

    @Autowired //Instancia al la clase del repository
    ItalikaRepository italikaRep;


    //Metodos

    //Get All Productos
    public ArrayList<ItalikaModel> obtenerProductos(){
            return (ArrayList<ItalikaModel>) italikaRep.findAll();
    }

    //Save Producto
    public ItalikaModel nuevoProducto(ItalikaModel producto){
        return italikaRep.save(producto);
    }

    //Search by id
    public Optional<ItalikaModel> buscarporID(Long id){
        return italikaRep.findById(id);
    }

    //Search by SKU
    public ArrayList<ItalikaModel> buscarporSKU(String sku){
        return italikaRep.findBySku(sku);
    }

    //Search by Modelo
    public ArrayList<ItalikaModel> buscarporModelo(String modelo){
        return italikaRep.findByModelo(modelo);
    }

    //Delete by ID
    public boolean eliminarProducto(Long id){
        try{
            italikaRep.deleteById(id);
            return true;
        } catch(Exception err){
            return false;
        }

    }
    
    
}
