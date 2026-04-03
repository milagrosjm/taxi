package com.solvd.taxi.model.payment;

public interface IPaymentMethod {

    public abstract void processPayment(double amount);
    
}
