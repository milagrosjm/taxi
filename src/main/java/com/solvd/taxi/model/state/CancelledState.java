package com.solvd.taxi.model.state;

public class CancelledState implements ITripState {
    
    @Override
    public String getStateName() {
        return "CANCELLED";
    }
    
}
