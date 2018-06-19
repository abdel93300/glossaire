package com.pe.glossaire.repository;


import com.pe.glossaire.model.Acronym;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcronymRepository extends CrudRepository<Acronym, Long> {


}