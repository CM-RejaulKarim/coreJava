package learnthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LearnThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        
        for (int i = 1; i <= 10; i++) {
            Runnable task= new MyTask(i);
            executorService.submit(task);
        }
        executorService.shutdown();
        
    }

}
