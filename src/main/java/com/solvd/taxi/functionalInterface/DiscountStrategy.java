package com.solvd.taxi.functionalInterface;

import com.solvd.taxi.model.trip.RequestTrip;

@FunctionalInterface
public interface DiscountStrategy {
    double apply(RequestTrip request);
}