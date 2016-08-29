package dk.kea.swc3.week34.oop;

/**
 * Created by coag on 25-08-2016.
 */
public class Car {
    private String color;

    public Car(){
        System.out.println("You crated a car.");
    }

    //this is block code. It will run before the constructor.
    {
        System.out.println("This is Alice");
    }


    public static void main(String[] args) {
        //System.out.println("in main");
        //dk.kea.swc3.week34.oop.Car car = new dk.kea.swc3.week34.oop.Car();

    }

    public void setColor(String color){
        this.color = color;
    }

    private class Engine{

    }
}
