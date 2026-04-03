package com.solvd.taxi.pricing;

import com.solvd.taxi.model.exception.InvalidPricing;

public class PriceCalculator{

    private double base;
    private double priceKm;

    public PriceCalculator(double base, double priceKm){
        this.base = base;
        this.priceKm = priceKm;
    }

    public double calculatePrice(double distance) throws InvalidPricing{
        if (distance < 0) {
            throw new InvalidPricing("Distance cannot be negative");
        }

        if (Double.isNaN(distance)) {
            throw new InvalidPricing("Distance is not valid");
        }

        return distance * this.priceKm + this.base;

    }

    public double getBase(){
        return this.base;
    }

    public double getPriceKm(){
        return this.priceKm;
    }

    public void setBase(double base){
        this.base = base;
    }

    public void setPriceKm(double priceKm){
        this.priceKm = priceKm;
    }
}
