package com.example.demo;

import com.example.demo.enumeration.BallType;
import com.example.demo.enumeration.BikeType;
import com.example.demo.model.Ball;
import com.example.demo.model.Bike;
import com.example.demo.model.Manufacturer;

import java.util.UUID;

public interface WithTestObjectFactory extends WithRandom {

    default Manufacturer randomManufacturer() {
        return new Manufacturer(randomUUID(), randomString(), randomString());
    }

    default Manufacturer randomManufacturer(final UUID manufacturerId) {
        return new Manufacturer(manufacturerId, randomString(), randomString());
    }

    default Bike randomBike() {
        final Bike bike = new Bike(randomEnum(BikeType.class));
        bike.setId(randomUUID());
        bike.setName(randomString());
        bike.setPrice(randomDouble());
        bike.setManufacturer(randomManufacturer());

        return bike;
    }

    default Ball randomBall() {
        final Ball ball = new Ball(randomEnum(BallType.class), randomIntMax(10));
        ball.setId(randomUUID());
        ball.setName(randomString());
        ball.setPrice(randomDouble());
        ball.setManufacturer(randomManufacturer());

        return ball;
    }
}