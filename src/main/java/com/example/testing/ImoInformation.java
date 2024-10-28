package com.example.testing;

public class ImoInformation {

    private int numberOfCrew;
    private int numberOfPassengers;

    public ImoInformation() {

    }

    public ImoInformation(int numberOfCrew, int numberOfPassengers) {
        this.numberOfCrew = numberOfCrew;
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getNumberOfCrew() {
        return numberOfCrew;
    }
    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
    public void setNumberOfCrew(int numberOfCrew) {
        this.numberOfCrew = numberOfCrew;
    }
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return numberOfCrew + " "+ numberOfPassengers;
    }
}
