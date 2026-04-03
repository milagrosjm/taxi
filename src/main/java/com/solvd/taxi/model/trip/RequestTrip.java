package com.solvd.taxi.model.trip;
import java.time.LocalDateTime;
import com.solvd.taxi.model.location.PointLocation;
import com.solvd.taxi.model.person.Passenger;


public class RequestTrip {

    private Passenger passenger;
    private PointLocation pointA;
    private PointLocation pointB;
    private LocalDateTime requestTime;
    private ITypeTrip type;

    public RequestTrip(Passenger passenger, PointLocation pA, PointLocation pB, LocalDateTime time, ITypeTrip type){
        this.passenger = passenger;
        this.pointA = pA;
        this.pointB = pB;
        this.requestTime = time;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("""
                REQUEST
                { passenger: %s %s
                  from: x: %s - y: %s
                  to: x: %s - y: %s
                  type: %s }
                """,
                passenger.getName(),
                passenger.getLastName(),
                pointA.getX(),
                pointA.getY(),
                pointB.getX(),
                pointB.getY(),
                type.getTypeName()
        );
    }

    public Passenger getPassenger(){
        return this.passenger;
    }

    public PointLocation getPointA(){
        return this.pointA;
    }

    public PointLocation getPointB(){
        return this.pointB;
    }

    public LocalDateTime getRequestTime(){
        return this.requestTime;
    }

    public ITypeTrip getTypeTrip(){
        return this.type;
    }

    public void setPassenger(Passenger passenger){
        this.passenger = passenger;
    }

    public void setPointA(PointLocation point){
        this.pointA = point;
    }

    public void setPointB(PointLocation point){
        this.pointB = point;
    }

    public void setTypeTrip(ITypeTrip type){
        this.type = type; 
    }

}

