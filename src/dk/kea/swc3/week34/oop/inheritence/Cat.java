package dk.kea.swc3.week34.oop.inheritence;

public class Cat {
    String name;
    public Cat() {
        System.out.println("In Cat()");
    }

    private void foo(){}
}

class Persian extends Cat {
    private int name;

    //@Override
    private void foo(){
        System.out.println("hi from Persina");
    }

    public Persian() {
        System.out.println("In Persian()");
        super.name = "Alice";
    }
    public static void main(String[] args) {
        Persian p = new Persian();
    }
}
