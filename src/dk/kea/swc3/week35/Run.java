package dk.kea.swc3.week35;

/**
 * Created by coag on 29-08-2016.
 */
public class Run {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("Alice");
        myList.add("Bob");
        myList.add("Bob");
        myList.add("Char");

        System.out.println(myList);
        System.out.println(myList.size());

    }
}
