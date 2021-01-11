package pl.camp.it.sumowanie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    public static List<Double> results = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        int[] tab = generateList();

        long timeStart = System.currentTimeMillis();
        Thread t1 = new Thread(new SumThread(tab, 0, tab.length/4));
        Thread t2 = new Thread(new SumThread(tab, tab.length/4, 2*tab.length/4));
        Thread t3 = new Thread(new SumThread(tab, 2*tab.length/4, 3*tab.length/4));
        Thread t4 = new Thread(new SumThread(tab, 3*tab.length/4, tab.length-1));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        double sum = Main.results.get(0) + Main.results.get(1) + Main.results.get(2) + Main.results.get(3);
        long timeEnd = System.currentTimeMillis();
        long algorithmTime = timeEnd - timeStart;
        System.out.println(sum);
        System.out.println(algorithmTime);
    }

    public static int[] generateList() {
        int[] tab = new int[500000000];
        Random random = new Random();

        for(int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(100000);
        }

        return tab;
    }

    public static double sumList(int[] tab) {
        double sum = 0;
        for(int element : tab) {
            sum = sum + Math.sqrt(Math.sqrt(Math.sqrt(element)));
        }
        return sum;
    }
}
