package dk.kea.swc3.week35;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by coag on 01-09-2016.
 */
public class RunListVsSet {
    public static void main(String[] args) {
        List<Character> letters = new ArrayList<>();
        letters.add('a');
        letters.add('b');
        System.out.println(letters);

        //O(n*m)
        int n=100,m=100;
        for (int i = 0; i < n; i++) { //O(n)
            for (int j = 0; j < m; j++) { //O(m)
                System.out.println(i);
            }
        }

    }
}
