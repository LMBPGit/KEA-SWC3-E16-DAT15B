package dk.kea.swc3.week35;

import java.util.Arrays;

/**
 * Created by coag on 29-08-2016.
 */
public class MyList<T>  {
    private T[] data;
    private int size;

    public MyList(){
        data = (T[])new Object[2];
        size = 0;
    }

    public void add(T element){
        if(size < data.length){
            data[size++] = element;
        } else {
            /*
            T[] temp = (T[]) new Object[size+10];
            for (int i = 0; i < size; i++) {
                temp[i] = data[i];
            }
            data = temp;
            */
            data = Arrays.copyOf(data, size+10); // this is the same as up
            data[size++] = element;
        }

    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size ; i++) {
            result += data[i] + " ";
        }
        return result;
    }
}




