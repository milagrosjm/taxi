package com.solvd.taxi.functionalInterface;

import com.solvd.taxi.model.location.PointLocation;

@FunctionalInterface
public interface DistanceCalculator {
    double calculate(PointLocation a, PointLocation b);
}
