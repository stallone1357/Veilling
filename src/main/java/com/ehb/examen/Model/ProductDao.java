package com.ehb.examen.Model;

import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
    public Product getProductById(int id);
}
