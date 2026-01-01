// Base Class
class Vehicle {
    protected int speed;   // in km/h
    protected double fuel; // in liters

    // Constructor
    public Vehicle(int speed, double fuel) {
        this.speed = speed;
        this.fuel = fuel;
    }

    // Method overloading: accelerate
    public void accelerate() {
        speed += 10;
        System.out.println("Vehicle accelerated by 10 km/h. Current speed: " + speed);
    }

    public void accelerate(int gear) {
        speed += gear * 10;
        System.out.println("Vehicle accelerated with gear " + gear + ". Current speed: " + speed);
    }

    // Method to be overridden
    public double mileage() {
        System.out.println("Generic vehicle mileage calculation.");
        return 0.0;
    }

    public void display() {
        System.out.println("Speed: " + speed + " km/h, Fuel: " + fuel + " liters");
    }
}

// Car subclass
class Car extends Vehicle {
    public Car(int speed, double fuel) {
        super(speed, fuel);
    }

    @Override
    public double mileage() {
        double mileage = fuel * 15; // assume 15 km/l
        System.out.println("Car mileage: " + mileage + " km");
        return mileage;
    }
}

// Bike subclass
class Bike extends Vehicle {
    public Bike(int speed, double fuel) {
        super(speed, fuel);
    }

    @Override
    public double mileage() {
        double mileage = fuel * 40; // assume 40 km/l
        System.out.println("Bike mileage: " + mileage + " km");
        return mileage;
    }
}

// Truck subclass
class Truck extends Vehicle {
    public Truck(int speed, double fuel) {
        super(speed, fuel);
    }

    @Override
    public double mileage() {
        double mileage = fuel * 8; // assume 8 km/l
        System.out.println("Truck mileage: " + mileage + " km");
        return mileage;
    }
}

// Main class
public class MainVehicle {
    public static void main(String[] args) {
        // Car
        Car car = new Car(60, 20);
        car.display();
        car.accelerate();
        car.accelerate(2);
        car.mileage();

        System.out.println("--------------------------");

        // Bike
        Bike bike = new Bike(40, 5);
        bike.display();
        bike.accelerate();
        bike.accelerate(3);
        bike.mileage();

        System.out.println("--------------------------");

        // Truck
        Truck truck = new Truck(50, 50);
        truck.display();
        truck.accelerate();
        truck.accelerate(4);
        truck.mileage();
    }
}
