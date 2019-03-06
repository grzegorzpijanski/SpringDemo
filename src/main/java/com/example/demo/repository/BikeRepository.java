package com.example.demo.repository;

import java.util.UUID;

import com.example.demo.model.Bike;
import org.springframework.data.repository.CrudRepository;

public interface BikeRepository extends CrudRepository<Bike, UUID> { }