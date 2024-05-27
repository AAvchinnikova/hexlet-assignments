package exercise;

import java.util.Map;

// BEGIN
public class InMemoryKV implements KeyValueStorage{
    private final Map<String, String> data;

    public InMemoryKV(Map<String, String > data) {
        this.data = data;
    }

    @Override
    public void set(String key, String value) {
       data.put(key, value);
    }

    @Override
    public void unset(String key) {
        String removed = data.remove(key);

    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Map.of();
    }
}
// END
