package dk.kea.swc3.week35;

/**
 * Created by coag on 29-08-2016.
 */
public class Run {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("A");
        myList.add("C");
        myList.add("D");
        myList.add("E");
        //myList.add(1,"B");


        System.out.println(myList);
//        System.out.println(myList.remove(-1));
//        System.out.println(myList.remove(0));
//        System.out.println(myList.remove(3));
        System.out.println(myList.remove(4));
        System.out.println(myList);
        System.out.println(myList.size());

        System.out.println(0xf);

    }
}
