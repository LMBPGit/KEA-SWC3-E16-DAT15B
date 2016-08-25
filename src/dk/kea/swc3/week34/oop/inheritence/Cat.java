package dk.kea.swc3.week34.oop.inheritence;

public class Cat {
    public Cat() {
        System.out.println("In Cat()");
    }
}

class Persian extends Cat {
    public Persian() {
        System.out.println("In Persian()");
    }
    public static void main(String[] args) {
        Persian p = new Persian();
    }
}
