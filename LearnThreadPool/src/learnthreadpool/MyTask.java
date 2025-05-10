package learnthreadpool;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyTask implements Runnable {

    private int taskId;

    public MyTask() {
    }

    public MyTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {

        System.out.println("Task: " + taskId + " is running on thread " + Thread.currentThread().getName());

        try {
            Thread.sleep(1000);

        } catch (InterruptedException ex) {
            Logger.getLogger(MyTask.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Task: " + taskId + " is running on thread " + Thread.currentThread().getName());

    }

}
