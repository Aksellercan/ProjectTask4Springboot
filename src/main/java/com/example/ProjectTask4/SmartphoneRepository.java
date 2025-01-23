package com.example.ProjectTask4;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SmartphoneRepository extends CrudRepository<Smartphone, Long> {
    List<Smartphone> findSmartphoneById(long id);
}