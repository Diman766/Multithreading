package org.example;

public class Table extends Thread {

    private final Philosopher[] PHILOSOPHERS = new Philosopher[5];
    private final Object[] FORKS = new Object[PHILOSOPHERS.length];


    public Table() {
        for (int i = 0; i < FORKS.length; i++) {
            FORKS[i] = new Object();
        }

    }


    @Override
    public void run() {
        for (int i = 0; i < PHILOSOPHERS.length; i++) {
            Object leftFork = FORKS[i];
            Object rightFork = FORKS[(i + 1) % FORKS.length];

            if (i == PHILOSOPHERS.length - 1) {

                PHILOSOPHERS[i] = new Philosopher(rightFork, leftFork);
            } else {
                PHILOSOPHERS[i] = new Philosopher(leftFork, rightFork);
            }

            Thread t = new Thread(PHILOSOPHERS[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}

