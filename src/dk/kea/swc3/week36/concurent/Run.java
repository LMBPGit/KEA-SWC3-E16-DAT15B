package dk.kea.swc3.week36.concurent;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by coag on 05-09-2016.
 */
public class Run {

    public static boolean isPrime(long n) {
        //throw new NotImplementedException();
        if (n != 2 && n % 2 == 0) return false;
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        LongCounter lc = new LongCounter(); // 0
        long max = 10_000_000;
        long noOfThreads = Runtime.getRuntime().availableProcessors()+30000;
        System.out.println(noOfThreads);

        Thread[] threads = new Thread[(int) noOfThreads];

        for (int i = 0; i < noOfThreads; i++) {
            final int temp = i;
            Thread t = new Thread(() -> {
                System.out.println(temp + ".Starting " + Thread.currentThread().getName());
                for (int j = (int) (temp * (max / noOfThreads)); j < (temp + 1) * (max / noOfThreads); j++) {
                    if (isPrime(j)) {
                        lc.increment();
                    }
                }
            });
            threads[i] = t;
        }
        System.out.println(threads.length);

        long start = System.currentTimeMillis();
        for (int i = 0; i < noOfThreads; i++) {
            threads[i].start();
        }


        for (int i = 0; i < noOfThreads; i++) {
            try {
                threads[i].join();
            } catch (Exception e) {
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println(lc.get());
        System.out.println("Execution time "+noOfThreads+"t: "+ (stop-start) + "ms");

        /*
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting " + Thread.currentThread().getName());
                for (long i = 2; i <= max / 2; i++) {
                    if (isPrime(i)) {
                        lc.increment();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Starting " + Thread.currentThread().getName());
            for (long i = max / 2 + 1; i < max; i++) {
                if (isPrime(i)) {
                    lc.increment();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            System.out.println("Starting " + Thread.currentThread().getName());
            for (long i = 2; i < max; i++) {
                if (isPrime(i)) {
                    lc.increment();
                }
            }
        });

        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }
        long stop = System.currentTimeMillis();
        System.out.println(lc.get());
        System.out.println("Execution time 2t: "+ (stop-start) + "ms");
        */
/*

        long start2 = System.currentTimeMillis();
        t3.start();
        try {
            t3.join();
        } catch (Exception e) {
        }
        long stop2 = System.currentTimeMillis();
        System.out.println(lc.get());
        System.out.println("Execution time 1t: "+ (stop2-start2) + "ms");
*/
    }
}
