interface Acceleratable {
    void accelerate(int increment);
    void accelerate(int increment, int gear);
}

abstract class Vehicle {
    double speed;
    double fuel;

    Vehicle(double speed, double fuel) {
        this.speed = speed;
        this.fuel = fuel;
    }

    abstract void mileage();

    public void display() {
        System.out.println("Speed: " + speed + " km/h, Fuel: " + fuel + " liters");
    }
}

class Car extends Vehicle implements Acceleratable {
    public Car(double speed, double fuel) {   
        super(speed, fuel);
    }

    @Override
    public void mileage() {
        double mileage = fuel * 15; 
        System.out.println("Car mileage: " + mileage + " km");
    }

    public void accelerate(int increment) {
        speed += increment;   
        System.out.println("New Speed: " + speed);
    }

    public void accelerate(int increment, int gear) {
        speed += increment+gear * 10;
        System.out.println("New Speed(gear): " + speed);
    }
}

class Bike extends Vehicle implements Acceleratable {
    public Bike(double speed, double fuel) {
        super(speed, fuel);
    }

    @Override
    public void mileage() {
        double mileage = fuel * 40; 
        System.out.println("Bike mileage: " + mileage + " km");
    }

    public void accelerate(int increment) {
        speed += increment;
        System.out.println("New Speed: " + speed);
    }

    public void accelerate(int increment, int gear) {
        speed += increment+ gear * 10;
        System.out.println("New Speed(gear): " + speed);
    }
}

class Truck extends Vehicle implements Acceleratable {
    public Truck(double speed, double fuel) {
        super(speed, fuel);
    }

    @Override
    public void mileage() {
        double mileage = fuel * 8; 
        System.out.println("Truck mileage: " + mileage + " km");
    }

    public void accelerate(int increment) {
        speed += increment;
        System.out.println("New Speed: " + speed);
    }

    public void accelerate(int increment, int gear) {
        speed += increment+ gear * 10;
        System.out.println("New Speed(gear): " + speed);
    }
}

public class MainVehicle {   
    public static void main(String[] args) {
        // Car
        System.out.println("---------Car -------------");
        Car car = new Car(60, 20);
        car.display();
        car.accelerate(2);
        car.accelerate(2, 2);
        car.mileage();

        System.out.println("--------Bike-------------");

        // Bike
        Bike bike = new Bike(40, 5);
        bike.display();
        bike.accelerate(3, 4);
        bike.accelerate(3);
        bike.mileage();

        System.out.println("--------Truck--------------");

        // Truck
        Truck truck = new Truck(50, 50);
        truck.display();
        truck.accelerate(4);
        truck.accelerate(4, 2);
        truck.mileage();
    }
}
