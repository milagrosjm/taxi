package com.solvd.taxi.model.trip;
import com.solvd.taxi.model.state.ITripState;
import com.solvd.taxi.model.person.Driver;

public class Trip {

    private Driver driver;
    private RequestTrip request;
    private double distance;
    private double price;
    private int waitingTime;
    private int travelingTime;
    private ITripState state;

    public Trip(Driver driver, RequestTrip request, double distance, double price, int waitingTime, int travelingTime, ITripState state){
        this.driver = driver;
        this.request = request;
        this.distance = distance;
        this.price = price;
        this.waitingTime = waitingTime;
        this.travelingTime = travelingTime;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("""
                TRIP 
                { passenger: %s %s
                  driver: %s %s
                  from: x: %s - y: %s
                  to: x: %s - y: %s
                  distance: %.2f 
                  price: %.2f
                  state: %s }
                """,
                request.getPassenger().getName(),
                request.getPassenger().getLastName(),
                driver.getName(),
                driver.getLastName(),
                request.getPointA().getX(),
                request.getPointA().getY(),
                request.getPointB().getX(),
                request.getPointB().getY(),
                distance,
                price,
                state.getStateName()
        );
    }

    public Driver getDriver(){
        return this.driver;
    }

    public RequestTrip getRequestTrip(){
        return this.request;
    }

    public double getDistance(){
        return this.distance;
    }

    public double getPrice(){
        return this.price;
    }

    public int getWaitingTime(){
        return this.waitingTime;
    }

    public int getTravelingTime(){
        return this.travelingTime;
    }

    public ITripState getState(){
        return this.state;
    }

    public void setDriver(Driver driver){
        this.driver = driver;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setWaitingTime(int time){
        this.waitingTime = time;
    }

    public void setTravelingTime(int time){
        this.travelingTime = time;
    }

    public void setState(ITripState state){
        this.state = state;
    }

}