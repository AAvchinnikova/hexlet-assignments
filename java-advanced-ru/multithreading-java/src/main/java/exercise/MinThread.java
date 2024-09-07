package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {

    private int[] numbers;

    private int minNumber;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {

        minNumber = Arrays.stream(numbers).min().getAsInt();
        System.out.println("Min value " + minNumber );

    }

    public int getMinNumber() {
        return minNumber;
    }
}
// END
