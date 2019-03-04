package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.demo.enumeration.BikeType;
import lombok.Getter;

@Entity
@Getter
public class Bike extends Product {

    @Column
    private BikeType type;
}