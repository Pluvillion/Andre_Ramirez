import java.util.Scanner;

// Base Class: Vehicle Testing (Using OOP.java as reference)

class Vehicle {
    private String brand;
    private double speed;
    private boolean fuelType;

    // Constructor
    public Vehicle(String brand, double speed, boolean fuelType) {
        this.brand = brand;
        this.speed = speed;
        this.fuelType = fuelType;
    }

    // Encapsulation: Getter and Setter Methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public boolean getFuelType() {
        return fuelType;
    }
}

// 1st subclass: Car
class Car extends Vehicle {
    private int numberOfDoors;

    // Constructor
    public Car(String brand, double speed, boolean fuelType, int numberOfDoors) {
        super(brand, speed, fuelType);
        this.numberOfDoors = numberOfDoors;
    }

    // Method to display car details
    public void displayCarDetails() {
        System.out.println("Brand: " + getBrand());
        System.out.println("BHP: " + getSpeed());
        System.out.println("Fuel Type: " + (getFuelType() ? "Petrol" : "Diesel"));
        System.out.println("Number of Doors: " + numberOfDoors);
    }
}

// 2nd subclass: Motorcycle
class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    // Constructor
    public Motorcycle(String brand, double speed, boolean fuelType, boolean hasSidecar) {
        super(brand, speed, fuelType);
        this.hasSidecar = hasSidecar;
    }

    // Method to display motorcycle details
    public void displayMotorcycleDetails() {
        System.out.println("Brand: " + getBrand());
        System.out.println("BHP: " + getSpeed());
        System.out.println("Fuel Type: " + (getFuelType() ? "Petrol" : "Diesel"));
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

// "TestVehicle" class for the Vehicle, Car, and Motorcycle classes
public class TestVehicle {
    public static void main(String[] args) {
        Scanner dealership = new Scanner(System.in);

        // Four-Wheels
        System.out.println("Enter the brand of the car: ");
        String carBrand = dealership.nextLine();
        System.out.println("Enter the car's BHP: ");
        double carBHP = dealership.nextDouble();
        dealership.nextLine();
        System.out.println("Enter the fuel type ('True' for Petrol, 'False' for Diesel): ");
        boolean carFuelType = dealership.nextBoolean();
        dealership.nextLine();
        System.out.println("Enter the number of doors: ");
        int carDoors = dealership.nextInt();
        dealership.nextLine();

        Car car = new Car(carBrand, carBHP, carFuelType, carDoors);
        car.displayCarDetails();

        // Two-wheels
        System.out.println("Enter the brand of the motorcycle: ");
        String motorcycleBrand = dealership.nextLine();
        System.out.println("Enter the motorcycle's BHP: ");
        double motorcycleBHP = dealership.nextDouble();
        dealership.nextLine();
        System.out.println("Enter the fuel type ('True' for Petrol, 'False' for Diesel): ");
        boolean motorcycleFuelType = dealership.nextBoolean();
        dealership.nextLine();
        System.out.println("Does it have a sidecar? ('True' for Yes, 'False' for No): ");
        boolean motorcycleSidecar = dealership.nextBoolean();

        Motorcycle motorcycle = new Motorcycle(motorcycleBrand, motorcycleBHP, motorcycleFuelType, motorcycleSidecar);
        motorcycle.displayMotorcycleDetails();

        dealership.close();
    }
}
