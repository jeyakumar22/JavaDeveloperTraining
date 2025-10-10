package oop.pillars;

public class Inheritence {
    public static void main(String[] args) {

        Car car = new Car();
        car.brand = "tata";
        car.model = "Camry";
        car.fuelType = "Diesel";
        car.year = 2025;
        car.seatCount = 5;

        car.start();
        car.displayInfo();
        car.stop();
        car.refuel();
        car.playMusic();

        Bike b = new Bike();
        b.brand = "yamaga";
        b.model = "R15v3";
        b.year = 2025;
        b.fuelType = "Petrol";

        b.start();
        b.displayInfo();
        b.stop();
        b.refuel();
        b.doStunt();


    }
}


class Vehicle {

    String brand;
    String model;
    int year;
    double price;

    void start() {
        System.out.println(brand + " " + model + " is starting");
    }

    void stop() {
        System.out.println(brand + " " + model + " is stopping");
    }

    void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }
}

class EngineVehicle extends  Vehicle{
    String fuelType ;
    int fuelCapacity;
    void refuel() {
        System.out.println("Refueling with " + fuelType);
    }
}
class Car extends  EngineVehicle{
    int seatCount;
    void playMusic(){
        System.out.println("music playing ");
    }
}

class Bike extends EngineVehicle{
    boolean hasHelmet;
    void doStunt(){
        System.out.println("stunting");
    }
    void stop(){
        System.out.println("stoped using hand break");
    }
}