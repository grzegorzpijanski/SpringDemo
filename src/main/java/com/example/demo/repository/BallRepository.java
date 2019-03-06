package com.example.demo.repository;

import java.util.UUID;

import com.example.demo.model.Ball;
import org.springframework.data.repository.CrudRepository;

public interface BallRepository extends CrudRepository<Ball, UUID> { }