package exercise;

class SafetyList {
    // BEGIN
    private int[] numbers;

    public SafetyList(int[] numbers) {
        this.numbers = numbers;
    }

    public SafetyList() {

    }

    public synchronized void add(int number) {
        var newNumbers = new int[numbers.length + 1];
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
        newNumbers[numbers.length] = number;
        numbers = newNumbers;
    }

    public int get(int index) {
        return numbers[index];
    }

    public int getSize() {
        return numbers.length;
    }
    // END
}
