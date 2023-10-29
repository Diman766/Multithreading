package org.example;

public class Philosopher implements Runnable {

    private final Object leftFork;
    private final Object rightFork;
    private int count = 3;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (count != 0) {
//                doAction(": Размышляет");
                synchronized (leftFork) {
//                    doAction(": Берет левую вилку");
                    synchronized (rightFork) {
                        doAction( ": Берет правую вилку - ест");
                        count--;
//                        doAction(": Кладет на стол правую вилку");
                    }
//                    doAction(": Кладет на стол левую вилку. Возвращается к размышлениям");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(100);
    }

}
