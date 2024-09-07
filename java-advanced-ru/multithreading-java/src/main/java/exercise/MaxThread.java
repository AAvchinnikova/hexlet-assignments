package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {

    private int[] numbers;

    private int maxNumber;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {

        maxNumber = Arrays.stream(numbers).max().getAsInt();
        System.out.println("Max value " + maxNumber );

    }

    public int getMaxNumber() {
        return maxNumber;
    }
}
// END
