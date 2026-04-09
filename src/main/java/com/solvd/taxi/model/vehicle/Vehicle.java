package com.solvd.taxi.model.vehicle;

import java.util.Set;

import com.solvd.taxi.enums.VehicleFeature;

public abstract class Vehicle{

    private String licensePlate; 
    private String model;
    private Set<VehicleFeature> features;

    public Vehicle (String licensePlate, String model, Set<VehicleFeature> features){
        this.licensePlate = licensePlate;
        this.model = model;
        this.features = features;
    }

    @Override
    public String toString() {
        return String.format("""
                VEHICLE 
                { license plate: %s
                  model: %s }
                """,
                licensePlate,
                model
        );
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        return licensePlate == vehicle.licensePlate;
    }

    @Override
    public int hashCode(){
        return licensePlate.hashCode();
    }

    public String getLicensePlate(){
        return this.licensePlate;
    }

    public String getModel(){
        return this.model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public Set<VehicleFeature> getFeatures(){
        return this.features;
    }

    public void setType(Set<VehicleFeature> features){
        this.features = features;
    }
}