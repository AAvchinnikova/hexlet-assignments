package exercise;

import java.util.Map;

// BEGIN
public class App {

    public static Map<String, String> swapKeyValue(KeyValueStorage object) {
        var result = object.toMap();
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value"));
        result.forEach((key, value) -> {
            object.set(value, key);
            object.unset(key);
        });
        System.out.println(storage.toMap());
        return object.toMap();
    }
}
// END
