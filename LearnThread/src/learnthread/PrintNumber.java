package learnthread;

public class PrintNumber implements Runnable {

    private int number;
    private int times;

    public PrintNumber() {
    }

    public PrintNumber(int number, int times) {
        this.number = number;
        this.times = times;
    }

    @Override
    public void run() {

        for (int i = 0; i < times; i++) {
            System.out.println(" " + number);
        }
    }

}
