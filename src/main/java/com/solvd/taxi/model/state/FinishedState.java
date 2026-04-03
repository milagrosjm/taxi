package com.solvd.taxi.model.state;

public class FinishedState implements ITripState {
        
    @Override
    public String getStateName() {
        return "FINISHED";
    }
    
}
