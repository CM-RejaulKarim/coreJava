package learnthread;

public class LearnThread {

    public static void main(String[] args) {

        Runnable a = new PrintChar('a', 50);
        Runnable b = new PrintChar('b', 50);
        Runnable c = new PrintChar('c', 50);
        Runnable d = new PrintChar('d', 50);
        Runnable e = new PrintChar('e', 50);
        Runnable f = new PrintNumber(4, 50);
        Runnable g = new PrintNumber(6, 50);

        Thread a1 = new Thread(a);
        Thread b1 = new Thread(b);
        Thread c1 = new Thread(c);
        Thread d1 = new Thread(d);
        Thread e1 = new Thread(e);
        Thread f1 = new Thread(f);
        Thread g1 = new Thread(g);

        a1.start();
        b1.start();
        c1.start();
        d1.start();
        e1.start();
        f1.start();
        g1.start();

    }

}
