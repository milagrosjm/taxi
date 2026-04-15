package com.solvd.taxi.pricing;

import java.net.Authenticator.RequestorType;

import com.solvd.taxi.functionalInterface.DiscountStrategy;
import com.solvd.taxi.model.exception.InvalidPricing;
import com.solvd.taxi.model.trip.RequestTrip;

public class PriceCalculator{

    private double base;
    private double priceKm;
    private DiscountStrategy priceStrategy;

    public PriceCalculator(double base, double priceKm, DiscountStrategy priceStrategy){
        this.base = base;
        this.priceKm = priceKm;
        this.priceStrategy = priceStrategy;
    }

    public double calculatePrice(double distance, RequestTrip request) throws InvalidPricing{
        double discount = priceStrategy.apply(request);
        if (distance < 0) {
            throw new InvalidPricing("Distance cannot be negative");
        }

        if (Double.isNaN(distance)) {
            throw new InvalidPricing("Distance is not valid");
        }

        return (distance * priceKm) + base - discount;

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
