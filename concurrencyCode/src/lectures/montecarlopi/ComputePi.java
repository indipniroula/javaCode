package lectures.montecarlopi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ComputePi {

    public static void main(String[] args) {
        final concurrentCounter numHits = new concurrentCounter();
        final concurrentCounter numMiss = new concurrentCounter();
        final int numSamples = 1_000_000;
        final int numThreads = 1;

        Thread[] threads = new Thread[numThreads];
        Arrays.setAll(threads, t -> new Thread(new MCIntegrator(numHits, numMiss, t, numSamples)));
        Arrays.stream(threads).forEach(t -> t.start());
        Arrays.stream(threads).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        double piEstimate = numHits.getCount()*4.0/(numHits.getCount() + numMiss.getCount());
        System.out.println(piEstimate);
    }


    private static class MCIntegrator implements Runnable{
        final concurrentCounter numHits;
        final concurrentCounter numMiss;
        final Random random;
        final int numSamples;

        private MCIntegrator(concurrentCounter numHits, concurrentCounter numMiss,
                             int randomSeed, int numSamples) {
            this.numHits = numHits;
            this.numMiss = numMiss;
            this.random = new Random(randomSeed);
            this.numSamples = numSamples;
        }


        @Override
        public void run() {
            IntStream.range(0, numSamples).forEach(i ->{
                final double x = random.nextDouble();
                final double y = random.nextDouble();

                /*When synchronizing using synchronize (this),make sure
                (this) object is shared by threads.
                synchronize (this) inside MCIntegrator - will have no effect
                Each thread has it's own MCIntegrator
                But each thread shares numHits, numMiss - so can synchronize that
                */

                boolean isHit = x*x + y*y <= 1;
                if(isHit) {
                    numHits.increment();
                } else {
                    numMiss.increment();
                }
            });
        }


    }

    private static class concurrentCounter {
        private long count = 0;

        public synchronized void increment() {
            count++;
        }

        public synchronized long getCount() {
            return count;
        }
    }
}
