package com.solvd.taxi.model.payment;

import com.solvd.taxi.Main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CashPayment implements IPaymentMethod {

    static {
        System.setProperty("log4j.configurationFile", "./src/main/resources/log4j2.xml");
    }

    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    
    @Override
    public void processPayment(double amount) {
        LOGGER.info("Paid with cash");
    }
    
}
