package dk.kea.swc3.week36;

import java.util.*;

/**
 * Created by coag on 05-09-2016.
 */
public class RunHashtbl {

    public static void main(String[] args) {
        Map<Integer, List<String>> grades = new HashMap<>();



        List<String> listOf12 = new ArrayList<>();
        listOf12.add("Alice");
        listOf12.add("Char");
        grades.put(12, listOf12);

        grades.put(7, new ArrayList<>());
        grades.get(7).add("Dan");

        grades.put(10, new ArrayList<>());
        grades.get(10).add("Bob");


        System.out.println(grades);

        /*
        7: Dan
        10: Bob
        12: Alice, Char
         */
        Set<Integer> keys = grades.keySet();
        for(Integer key: keys){
            List<String> listNames = grades.get(key);
            String result = ""+key + ": ";
            for(String name: listNames){
                result += name + ", ";
            }
            result = result.substring(0, result.lastIndexOf(','));
            System.out.println(result);
        }

        //TODO - 05/09-2016
        String result = "";
        grades.forEach((key, val) ->{
            result.concat(key + ": ");
            val.forEach(name -> {
                result.concat(name +" ");
            });
            //System.out.println(val);
        });
        System.out.println("Rs> " + result);


    }
}








