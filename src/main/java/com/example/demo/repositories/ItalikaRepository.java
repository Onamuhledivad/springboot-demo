package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ItalikaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItalikaRepository extends JpaRepository<ItalikaModel, Long>{

    //Proceso Almacenado Listar Productos
    @Query(value = "{call listar_productos()}", nativeQuery = true)
    ArrayList<ItalikaModel> getProductos();

    //Proceso Almacenado para insertar nuevo Producto
    @Query(value = "{call insert_producto(:skuIn, :fertIn, :modeloIn, :tipoIn, :noserieIn, :fechaIn)}", nativeQuery = true)
    void newProducto(
               @Param("skuIn")String skuIn,
               @Param("fertIn")String fertIn,
               @Param("modeloIn")String modeloIn,
               @Param("tipoIn")String tipoIn,
               @Param("noserieIn")Long noserieIn,
               @Param("fechaIn")String fechaIn
       );

    //Proceso Almacenado para buscar por id
    @Query(value = "{call list_by_id(:idIn)}", nativeQuery = true)
    Optional<ItalikaModel> listProductobyId(@Param("idIn") Long idIn);


    //Proceso Almacenado para buscar por SKU
    @Query(value = "{call list_by_sku(:skuIn)}", nativeQuery = true)
    ArrayList<ItalikaModel> listProductobySku(@Param("skuIn") String skuIn);

     //Proceso Almacenado para buscar por Modelo
     @Query(value = "{call list_by_modelo(:modeloIn)}", nativeQuery = true)
     ArrayList<ItalikaModel> listProductobyModelo(@Param("modeloIn") String modeloIn);


     //Proceso Almacenado para eliminar producto por id
     @Query(value = "{call delete_by_id(:idIn)}", nativeQuery = true)
     void deleteProducto(@Param("idIn") Long inIn);
    
    
}
