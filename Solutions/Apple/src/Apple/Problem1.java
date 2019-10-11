package Apple;

/*

Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.

*/

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Problem1 {

    private static ScheduledExecutorService executor;

    public static void main(String args[]) {
        executor = Executors.newSingleThreadScheduledExecutor();

        scheduleTask(() -> System.out.println("Ola Mundo"), 1000);

        executor.shutdown();
        executor = null;
    }

    private static void scheduleTask(Runnable runnable, int delay) {
        executor.schedule(runnable, delay, TimeUnit.MILLISECONDS);
    }
}
