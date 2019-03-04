package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    protected Long id;

    @Column
    private String name;

    @Column
    private double price;

    @ManyToOne
    @JoinTable(name = "ProductManufacturer", joinColumns = {@JoinColumn(name ="productId", referencedColumnName = "id") }, inverseJoinColumns = {@JoinColumn(name = "manufacturerId", referencedColumnName = "id")})
    private Manufacturer manufacturer;
}