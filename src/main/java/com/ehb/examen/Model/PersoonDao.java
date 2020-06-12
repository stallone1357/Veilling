package com.ehb.examen.Model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersoonDao extends CrudRepository<Persoon, Integer> {

    @Query("SELECT products FROM Persoon")
    public List<Product> getProductByPersoonId(int id);

}
