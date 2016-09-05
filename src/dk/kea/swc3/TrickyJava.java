package dk.kea.swc3;

/**
 * Created by coag on 01-09-2016.
 */
public class TrickyJava {
    public static void main(String[] args) {
        /*
        //Q.1
        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
        System.out.println(Math.min(Integer.MIN_VALUE, 0));
        //Q.2
        System.out.println(1.0/.0);
        */
        //Q.3

        try{
            System.out.println("in try");
            return;
            //System.out.println(args[0]);
            //System.exit(666);
        } catch (Exception ex){
            System.out.println("in catch");
        } finally {
            System.out.println("in finally");
        }

    }
}
