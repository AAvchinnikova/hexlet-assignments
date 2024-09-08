package exercise;

class SafetyList {
    // BEGIN
    private int[] numbers = new int[0];

    public SafetyList(int[] numbers) {
        this.numbers = numbers;
    }

    public SafetyList() {

    }

    public synchronized void add(int value) {
        var newNumbers = new int[numbers.length + 1];
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
        newNumbers[numbers.length] = value;
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
