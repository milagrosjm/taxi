package com.solvd.taxi.model.state;

public class DriverAssignedState implements ITripState {

    @Override
    public String getStateName() {
        return "DRIVER_ASSIGNED";
    }
    
}
