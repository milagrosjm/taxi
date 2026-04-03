package com.solvd.taxi.model.person;
import java.time.LocalDate;

import com.solvd.taxi.model.location.PointLocation;
import com.solvd.taxi.model.payment.IPaymentMethod;


public class Passenger extends Person {

    private IPaymentMethod preferredPaymentMethod;

    public Passenger(String name, String lastName, int id, LocalDate birthDate, 
        String phoneNumber, String email, IPaymentMethod preferredMethod, PointLocation location){
        super(name, lastName, id, birthDate, phoneNumber, email, location);
        this.preferredPaymentMethod = preferredMethod;

    }

    public IPaymentMethod getPaymentMethod(){
        return this.preferredPaymentMethod;
    }

    public void setPaymentMethod(IPaymentMethod paymentMethod){
        this.preferredPaymentMethod = paymentMethod;
    }

}
