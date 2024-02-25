package vehiclefactory;

class FactoryDesignPattern{
    public static void main(String[] args){
        // Create factory class method
        VehicleFactory factory = new VehicleFactory();

        //create car class method using factory
        Vehicle car = factory.createVehicleObject("car");
        car.manufacture();

        //create truck class method using factory
        Vehicle truck = factory.createVehicleObject("truck");
        truck.manufacture();
    }
}