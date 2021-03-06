package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.demo.enumeration.BallType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ball extends Product {

    @Column
    private BallType type;

    @Column
    private int size;
}