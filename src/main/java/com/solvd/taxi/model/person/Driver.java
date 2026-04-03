package com.solvd.taxi.model.person;
import java.time.LocalDate;
import com.solvd.taxi.model.location.PointLocation;
import com.solvd.taxi.enums.DriverStatus;
import com.solvd.taxi.model.vehicle.Vehicle;

public class Driver extends Person {

    private Vehicle [] vehicles ;
    private DriverStatus status; // avaible, off, occupied

    public Driver(String name, String lastName, int id, LocalDate birthDate, 
        String phoneNumber, String email, Vehicle [] vehicles, 
        DriverStatus status, PointLocation location){
        super(name, lastName, id, birthDate, phoneNumber, email, location);
        this.vehicles = vehicles;
        this.status = status;

    }

    public void setStatus (DriverStatus newStatus) {
        this.status = newStatus;
    }

    public DriverStatus getStatus(){
        return this.status;
    }

    public Vehicle [] getVehicles(){
        return this.vehicles;
    }

    public void setTaxi(Vehicle [] vehicles){
        this.vehicles = vehicles;
    }


}
