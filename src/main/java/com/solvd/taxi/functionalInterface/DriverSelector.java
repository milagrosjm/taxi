package com.solvd.taxi.functionalInterface;

import java.util.List;

import com.solvd.taxi.model.exception.DriverNotAvailable;
import com.solvd.taxi.model.person.Driver;

@FunctionalInterface
public interface DriverSelector<D extends Driver> {
    D select(List<D> drivers) throws DriverNotAvailable;
}
