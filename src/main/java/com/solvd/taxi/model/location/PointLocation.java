package com.solvd.taxi.model.location;

import java.util.Objects;

public class PointLocation {

    private double x;
    private double y;

    public PointLocation (double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("""
                LOCATION 
                { x: %s
                  y: %s }
                """,
                x,
                y
        );
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointLocation pointLocation = (PointLocation) o;

        if (Double.compare(pointLocation.x, x) != 0) return false;
        return Double.compare(pointLocation.y, y) == 0; 
    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

}
