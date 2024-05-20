package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// BEGIN
public class ReversedSequence implements CharSequence{

    public static String reversedSequence(CharSequence data) {
    List<Character> resultList = new ArrayList<>();
    for (var i = data.length() - 1; i >= 0; i--) {
        resultList.add(data.charAt(i));
    }
    String result = resultList.stream().map(Object::toString).collect(Collectors.joining());
    return result;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return null;
    }

    @Override
    public char charAt(int i) {
        return 0;
    }
}
// END
