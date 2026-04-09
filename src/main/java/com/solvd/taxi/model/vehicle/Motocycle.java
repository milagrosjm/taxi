package com.solvd.taxi.model.vehicle;

import java.util.Set;

import com.solvd.taxi.enums.VehicleFeature;

public class Motocycle extends Vehicle {
    
    public Motocycle (String licensePlate, String model, Set<VehicleFeature> features){
        super(licensePlate, model, features);
    }
    
}
