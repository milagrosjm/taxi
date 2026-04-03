package com.solvd.taxi.model.state;

public class RejectedState implements ITripState {
    
    @Override
    public String getStateName() {
        return "REJECTED";
    }
    
}
