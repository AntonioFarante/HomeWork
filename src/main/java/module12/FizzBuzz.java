package module12;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzz {
    private final int num = 20;
    public static volatile AtomicInteger number = new AtomicInteger(1);
    public BlockingQueue result = new LinkedBlockingDeque();

    public synchronized void add(String element) {
        result.add(element);
    }

    public synchronized void fizz() {
        while (number.get() < num) {
            if (number.get() % 3 == 0 && number.get() % 5 != 0) {
                add("fizz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }
    }

    public synchronized void buzz() {
        while (number.get() < num) {
            if (number.get() % 5 == 0 && number.get() % 3 != 0) {
                add("buzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }
    }

    public synchronized void fizzBuzz() {
        while (number.get() < num) {
            if (number.get() % 15 == 0) {
                add("fizzBuzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }
    }

    public synchronized void number() {
        while (number.get() < num) {
            if (number.get() % 3 != 0 && number.get() % 5 != 0) {
                add(String.valueOf(number.get()));
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }
    }
    public void printResult () {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
            while (!result.isEmpty()) {
                System.out.println(result.poll());
            }
        }
    }
}
