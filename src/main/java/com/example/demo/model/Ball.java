package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.demo.enumeration.BallType;
import lombok.Getter;

@Entity
@Getter
public class Ball extends Product {

    @Column
    private BallType type;

    @Column
    private int size;
}