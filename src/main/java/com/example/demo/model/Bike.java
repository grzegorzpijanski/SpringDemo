package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.demo.enumeration.BikeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bike extends Product {

    @Column
    private BikeType type;
}