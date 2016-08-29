package dk.kea.swc3.week34.datatypes;

/**
 * Created by coag on 25-08-2016.
 */
public class Run {

    /**
     * This is a nice method. <b style="color: red">Use it</b>
     * @param name This is a string
     * @return this method will return an int
     */
    public static int foo(String name){
        return 7;
    }


    public static void main(String[] args) {
        /*
        multiline comment
         */
        boolean b = false;
        double dd = 0.1; //in line comment
        dd += 0.1;
        dd += 0.1;
        dd += 0.1;
        dd += 0.1;
        dd += 0.1;

        dd += 0.1;
        dd += 0.1;
        dd += 0.1;
        dd += 0.1;

        System.out.println((0.2*10+.1*10)/10);

        float fl = 0.5f;

        char c = 'd';
        //System.out.println('a' > 'A');


        long l = 3_457_435_566L;
        int i = 42;
        short sh = 69;
        byte by = 126;

        /*
        byte temp = 1 ;
        while (temp > 0){
            System.out.println("Alice"+temp);
            temp++;
        }
        System.out.println("temp after loop "+temp);
        */

        /*
        int j = 5;
        System.out.println(j);
        System.out.println(++j);
        System.out.println(j++);
        System.out.println(j);
        */

        System.out.println(3 % 9);
    }
}
