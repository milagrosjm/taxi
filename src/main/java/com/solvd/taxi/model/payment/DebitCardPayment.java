package com.solvd.taxi.model.payment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.taxi.Main;

public class DebitCardPayment implements IPaymentMethod {

    static {
        System.setProperty("log4j.configurationFile", "./src/main/resources/log4j2.xml");
    }

    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    
    @Override
    public void processPayment(double amount) {
        LOGGER.info("Paid with debit card");
    }
    
}