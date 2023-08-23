// Product interfaces
interface Car {
    void drive();
}

interface Engine {
    void start();
}

// Concrete products
class SedanCar implements Car {
    public void drive() {
        System.out.println("Driving a Sedan car.");
    }
}

class SUVCar implements Car {
    public void drive() {
        System.out.println("Driving an SUV car.");
    }
}

class ElectricEngine implements Engine {
    public void start() {
        System.out.println("Starting an electric engine.");
    }
}

class GasolineEngine implements Engine {
    public void start() {
        System.out.println("Starting a gasoline engine.");
    }
}

// Abstract factory interface
interface CarFactory {
    Car createCar();
    Engine createEngine();
}

// Concrete factory implementations
class SedanCarFactory implements CarFactory {
    public Car createCar() {
        return new SedanCar();
    }

    public Engine createEngine() {
        return new GasolineEngine();
    }
}

class SUVCarFactory implements CarFactory {
    public Car createCar() {
        return new SUVCar();
    }

    public Engine createEngine() {
        return new GasolineEngine();
    }
}

class ElectricCarFactory implements CarFactory {
    public Car createCar() {
        return new SedanCar();
    }

    public Engine createEngine() {
        return new ElectricEngine();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Choose the factory based on requirements
        CarFactory sedanFactory = new SedanCarFactory();
        CarFactory suvFactory = new SUVCarFactory();
        CarFactory electricFactory = new ElectricCarFactory();

        // Create sedan car and start its engine
        Car sedanCar = sedanFactory.createCar();
        Engine sedanEngine = sedanFactory.createEngine();
        sedanCar.drive();
        sedanEngine.start();

        // Create SUV car and start its engine
        Car suvCar = suvFactory.createCar();
        Engine suvEngine = suvFactory.createEngine();
        suvCar.drive();
        suvEngine.start();

        // Create electric car and start its engine
        Car electricCar = electricFactory.createCar();
        Engine electricEngine = electricFactory.createEngine();
        electricCar.drive();
        electricEngine.start();
    }
}
