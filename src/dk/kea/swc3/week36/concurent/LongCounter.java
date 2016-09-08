package dk.kea.swc3.week36.concurent;

/**
 * Created by coag on 05-09-2016.
 */
public class LongCounter {
    private volatile long count = 0;

    public void increment(){
        synchronized(this){
            count = count + 1;
        }
    }

    public long get(){
        return count;
    }
}
