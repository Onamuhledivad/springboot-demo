package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ItalikaModel;
import com.example.demo.repositories.ItalikaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItalikaServices {

    @Autowired //Instancia al la clase del repository
    ItalikaRepository italikaRep;


    //Metodos

    //Get All Productos
    public ArrayList<ItalikaModel> obtenerProductosService(){
            //Procedure 
            return italikaRep.getProductos();
    }

    //New Producto
    //Insert Procedure
    public void nuevoProductoService(ItalikaModel producto){
        italikaRep.newProducto(producto.getSku(), producto.getFert(), producto.getModelo(), producto.getTipo(), producto.getNo_serie(), producto.getFecha() );
    }

    //Search by id
    public Optional<ItalikaModel> buscarporIdService(Long id){
        //Procedure
        return italikaRep.listProductobyId(id);
    }

    //Search by SKU
    public ArrayList<ItalikaModel> buscarporSkuService(String sku){
        //Procedure
        return italikaRep.listProductobySku(sku);
    }

    //Search by Modelo
    public ArrayList<ItalikaModel> buscarporModeloService(String modelo){
        //Procedure
        return italikaRep.listProductobyModelo(modelo);
    }

    //Delete by ID
    public void eliminarProductoService(Long id){
            //Procedure
            italikaRep.deleteProducto(id);
    }
    
    
}
