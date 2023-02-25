package module12;

import java.util.Date;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        long timeStartingProgram = new Date().getTime();
        new MyThread().start();
        while (true) {
            System.out.println((new Date().getTime()) - timeStartingProgram);
            Thread.sleep(1000);
        }
    }
}

class MyThread extends Thread {
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println("Прошло 5 секунд");
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
