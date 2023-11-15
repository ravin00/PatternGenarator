package Q1;

public class Pattern1 extends Thread {

    private Object lock;
    private String pattern;
    private int count;

    public Pattern1(Object lock, String pattern, int count) {
        super();
        this.lock = lock;
        this.pattern = pattern;
        this.count = count;
    }

    @Override
    public void run() { // Note: It should be run() not Run()

        synchronized (lock) {
            for (int i = 0; i < count; i++) {
                System.out.print("Pattern 1 Thread: ");

                for (int j = 0; j < count - i; j++) { // Corrected the loop condition for printing spaces
                    System.out.print(" ");
                }

                for (int j = 0; j < i + 1; j++) { // prints the pattern
                    System.out.print(pattern + " ");
                }
                System.out.println();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
                try {
                    if (i < count - 1) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
