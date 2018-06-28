package com.pe.glossaire.repository;


import com.pe.glossaire.model.Acronym;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcronymRepository extends CrudRepository<Acronym, Long> {

    List<Acronym> findByName(String name);

}