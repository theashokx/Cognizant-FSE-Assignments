class Car 
{
    String make;
    String model;
    int year;

    Car(String make, String model, int year) 
    {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    void displayDetails() 
    {
        System.out.println("Make : " + make);
        System.out.println("Model : " + model);
        System.out.println("Year : " + year);
        System.out.println();
    }

    public static void main(String[] args) 
    {
        Car car1 = new Car("Hyundai", "Creta", 2020);
        Car car2 = new Car("Toyota", "Innova", 2022);

        car1.displayDetails();
        car2.displayDetails();
    }
}