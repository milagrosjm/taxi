package com.solvd.taxi.model.vehicle;

import java.util.Set;

import com.solvd.taxi.enums.VehicleFeature;

public class Car extends Vehicle{

    public Car (String licensePlate, String model, Set<VehicleFeature> features){
        super(licensePlate, model, features);
    }

}

