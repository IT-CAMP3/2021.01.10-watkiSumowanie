package pl.camp.it.sumowanie;

public class SumThread implements Runnable {

    int[] tab;
    int startIndex;
    int endIndex;

    SumThread(int[] tab, int startIndex, int endIndex) {
        this.tab = tab;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        double sum = 0;
        for(int i = startIndex; i < endIndex; i++) {
            sum = sum + Math.sqrt(Math.sqrt(Math.sqrt(this.tab[i])));
        }
        Main.results.add(sum);
    }
}
