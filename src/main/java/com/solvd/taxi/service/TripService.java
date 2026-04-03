package com.solvd.taxi.service;
import com.solvd.taxi.enums.DriverStatus;
import com.solvd.taxi.model.exception.DriverNotAvailable;
import com.solvd.taxi.model.exception.InvalidLocation;
import com.solvd.taxi.model.exception.InvalidPricing;
import com.solvd.taxi.model.location.PointLocation;
import com.solvd.taxi.model.person.Driver;
import com.solvd.taxi.model.state.DriverAssignedState;
import com.solvd.taxi.model.trip.*;
import com.solvd.taxi.pricing.PriceCalculator;

import java.util.List;

public class TripService <D extends Driver, R extends RequestTrip, T extends Trip> {

    private PriceCalculator priceCalculator;

    public TripService(PriceCalculator priceCalculator){
        this.priceCalculator = priceCalculator;
    }

    public PriceCalculator getPriceCalculator(){
        return this.priceCalculator;
    }

    public void setPriceCalculator(PriceCalculator priceCalculator){
        this.priceCalculator = priceCalculator;
    }

    public T createTrip(R request, List<D> drivers) throws DriverNotAvailable, InvalidLocation, InvalidPricing {

        int travelingTime = this.calculateTravelingTime(request.getPointA(), request.getPointB());

        D driver = findDriver(drivers, request.getPointA());

        double distance = this.calculateDistance(request.getPointA(), request.getPointB());

        double price = this.priceCalculator.calculatePrice(distance);

        int waitingTime = this.calculateWaitingTime(driver, request.getPointA());

        DriverAssignedState assignedState = new DriverAssignedState();

        return (T) new Trip(driver, request, distance, price, waitingTime, travelingTime, assignedState);


    }


    public D findDriver(List<D> drivers, PointLocation pointA) throws DriverNotAvailable{

        if (drivers == null || drivers.isEmpty()){
            throw new DriverNotAvailable("There are no drivers connected");
        }

        for (D driver : drivers) {
        if (driver.getStatus() == DriverStatus.AVAILABLE) {
            driver.setStatus(DriverStatus.OCCUPIED);
            return driver;
        }
    }
        throw new DriverNotAvailable("There are no drivers available");
    }

    private double calculateDistance (PointLocation pointA, PointLocation pointB) throws InvalidLocation{
        
        if (pointA == null || pointB == null) {
            throw new InvalidLocation("Location cannot be null");
        }
        
        double dx = pointA.getX() - pointB.getX();
        double dy = pointA.getY() - pointB.getY();

        return Math.sqrt(dx*dx + dy*dy);

    }

    private int calculateWaitingTime(D driver, PointLocation pointA) throws InvalidLocation{
        double distance = calculateDistance(
        driver.getLocation(),
        pointA
    );

    return (int)(distance * 2);

    }

    private int calculateTravelingTime(PointLocation pointA, PointLocation pointB) throws InvalidLocation{
        double distance = this.calculateDistance(pointA, pointB);
        return (int) (distance * 2);
    }

}
