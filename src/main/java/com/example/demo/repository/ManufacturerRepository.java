package com.example.demo.repository;

import java.util.UUID;

import com.example.demo.model.Manufacturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends CrudRepository<Manufacturer, UUID> { }