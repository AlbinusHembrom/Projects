interface ahVehicle {
    void start();
    void stop();
    void accelerate();
}

interface ahElectricVehicle extends ahVehicle { }

class ahElectricCar implements ahElectricVehicle {
    public void start() { System.out.println("ahElectricCar: Starting silently..."); }
    public void stop() { System.out.println("ahElectricCar: Charging system engaged."); }
    public void accelerate() { System.out.println("ahElectricCar: Instant torque!"); }
}

class ahBike implements ahVehicle {
    public void start() { System.out.println("ahBike: Ready to ride."); }
    public void stop() { System.out.println("ahBike: Braking to a halt."); }
    public void accelerate() { System.out.println("ahBike: Pedaling harder!"); }
}

class ahBus implements ahVehicle {
    public void start() { System.out.println("ahBus: Heavy engine starting..."); }
    public void stop() { System.out.println("ahBus: Stopping at the station."); }
    public void accelerate() { System.out.println("ahBus: Slowly gaining momentum."); }
}

class ahTaxi implements ahVehicle {
    public void start() { System.out.println("ahTaxi: Meter started."); }
    public void stop() { System.out.println("ahTaxi: Arrived at destination."); }
    public void accelerate() { System.out.println("ahTaxi: Speeding up."); }
}

public class AHElectricVehicle {
    public static void main(String[] args) {
        // Create the objects
        ahVehicle myCar = new ahElectricCar();
        ahVehicle myBike = new ahBike();
        ahVehicle myBus = new ahBus();
        ahVehicle myTaxi = new ahTaxi();

        // Run their methods
        System.out.println("--- Transportation System Starting ---");
        myCar.start();
        myBike.accelerate();
        myBus.stop();
        myTaxi.start();
    }
}

/*
Developer use case based on abstraction using interfaces (can do relationship) :
Scenario 2: We are developing a software for a transportation system.
We can create an interface called "Vehicle" that defines common behaviors of all vehicles,
such as start(), stop(), and accelerate().
Then, we can create specific classes like "Car", "Bike", and "Bus" that implement the
Vehicle interface and provide their own implementations of the methods.
*/