package com.solvd.taxi.enums;

public enum DriverRating {

    ONE_STAR(1, "Very bad"),
    TWO_STARS(2, "Bad"),
    THREE_STARS(3, "Average"),
    FOUR_STARS(4, "Good"),
    FIVE_STARS(5, "Excellent");

    private final int stars;
    private final String description;

    DriverRating(int stars, String description) {
        this.stars = stars;
        this.description = description;
    }

    public int getStars() {
        return stars;
    }

    public String getDescription() {
        return description;
    }
}