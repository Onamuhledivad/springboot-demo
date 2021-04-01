package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.ItalikaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItalikaRepository extends CrudRepository<ItalikaModel, Long>{

    public abstract ArrayList<ItalikaModel> findBySku(String sku);

    public abstract ArrayList<ItalikaModel> findByModelo(String modelo);
    
}
