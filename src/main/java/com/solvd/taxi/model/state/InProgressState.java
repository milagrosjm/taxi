package com.solvd.taxi.model.state;

public class InProgressState implements ITripState {
    
    @Override
    public String getStateName() {
        return "IN_PROGRESS";
    }
    
}
