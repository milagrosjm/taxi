package com.solvd.taxi;

import java.io.IOException;
import java.time.*;
import java.util.*;

import com.solvd.taxi.enums.*;
import com.solvd.taxi.functionalInterface.DistanceCalculator;
import com.solvd.taxi.functionalInterface.DiscountStrategy;
import com.solvd.taxi.model.trip.*;
import com.solvd.taxi.model.exception.DriverNotAvailable;
import com.solvd.taxi.model.exception.InvalidLocation;
import com.solvd.taxi.model.exception.InvalidPricing;
import com.solvd.taxi.model.generics.Pair;
import com.solvd.taxi.model.generics.ServiceResult;
import com.solvd.taxi.model.location.*;
import com.solvd.taxi.model.payment.*;
import com.solvd.taxi.model.person.*;
import com.solvd.taxi.model.vehicle.*;
import com.solvd.taxi.pricing.*;
import com.solvd.taxi.service.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.taxi.FileAnalysis;

public class Main {


    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

    Car taxi1 = new Car("EJL768", "Corsa",  Set.of(VehicleFeature.AIR_CONDITIONING, VehicleFeature.PET_FRIENDLY));
    Motocycle moto = new Motocycle("EJL123", "Honda", Set.of());
    Vehicle [] vehicles = {taxi1, moto};
    PointLocation locationDriver = new PointLocation(3.444, 100.333);
    Driver driver1 = new Driver(
    "Jorge", 
    "Moreno", 
    17234657, 
    LocalDate.of(1998, 9, 13), 
    "+54351768543", 
    "jorgemoreno@gmail.com", 
    vehicles, 
    DriverStatus.AVAILABLE, 
    locationDriver,
    DriverRating.FOUR_STARS);
    
    Map<Driver, Vehicle[]> driverVehicles = new HashMap<>();
    driverVehicles.put(driver1, vehicles);

    List<Driver> drivers = new ArrayList<>();
    drivers.add(driver1);

    DebitCardPayment paymentMethod = new DebitCardPayment();
    PointLocation locationPassenger = new PointLocation(11.500, 1.333);
    Passenger passenger1 = new Passenger(
        "Julian", 
        "Perez", 
        9123456, 
        LocalDate.of(1978, 10, 30), 
        "+54351768333", 
        "julianperez@gmail.com", 
        paymentMethod,
        locationPassenger
    );

    Set<Passenger> passangers = new HashSet<>();
    passangers.add(passenger1);

    PointLocation locationA = new PointLocation(11.444, 1.333);
    PointLocation locationB = new PointLocation(100.444, 0.333);
    NormalTrip typeTrip = new NormalTrip();
    RequestTrip request = new RequestTrip(
        passenger1, 
        locationA, 
        locationB, 
        LocalDateTime.now(), 
        typeTrip);   

    Queue<RequestTrip> tripQueue = new LinkedList<>();
    tripQueue.add(request);

    DiscountStrategy nightDiscount = r -> {
        int hour = r.getRequestTime().getHour();
        return (hour >= 22) ? 50 : 0;
    };

    PriceCalculator priceCalculator = new PriceCalculator(150, 30, nightDiscount);

    Deque<Trip> tripHistory = new ArrayDeque<>();

    DistanceCalculator euclidean = (a, b) -> {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        return Math.sqrt(dx * dx + dy * dy);
    };

    TripService<Driver, RequestTrip, Trip> service = new TripService<>(priceCalculator, euclidean);
    try {
        RequestTrip nextRequest = tripQueue.poll();
        Trip trip = service.createTrip(nextRequest, drivers, ds ->
            ds.stream()
            .filter(d -> d.getStatus() == DriverStatus.AVAILABLE)
            .findFirst()
            .map(d -> {
                d.setStatus(DriverStatus.OCCUPIED);
                return d;
            })
            .orElseThrow(() -> new DriverNotAvailable("No drivers available"))
        );
        tripHistory.push(trip);
        ServiceResult<Trip> result = new ServiceResult<>(trip, "Trip created successfully");
        Trip createdTrip = result.getData();

        Pair<Driver, Vehicle[]> driverVehiclePair = new Pair<>(driver1, vehicles);
        
        LOGGER.info("Driver: " + createdTrip.getDriver().getName() + " " + createdTrip.getDriver().getLastName());
        LOGGER.info("Driver " + driverVehiclePair.getKey().getName() + " has vehicles: " + driverVehiclePair.getValue().length);
        LOGGER.info("Price: " + createdTrip.getPrice());
        LOGGER.info("Waiting time: " + createdTrip.getWaitingTime());
        LOGGER.info("Traveling time: " + createdTrip.getTravelingTime());

        LOGGER.info("Passengers registered: " + passangers.size());
        LOGGER.info("Trips in history: " + tripHistory.size());

    } catch (DriverNotAvailable e){
        LOGGER.error(e.getMessage());
    } catch (InvalidLocation e){
        LOGGER.error(e.getMessage());
    } catch (InvalidPricing e){
        LOGGER.error(e.getMessage());
    }
    
    try{
        FileAnalysis.countWordsFromFile(
            "src/main/resources/input.txt",
            "src/main/resources/output.txt",
            Arrays.asList("QA", "testing","tester")
        );
    } catch (IOException e) {
        LOGGER.error(e.getMessage());
    }

    }
}





















