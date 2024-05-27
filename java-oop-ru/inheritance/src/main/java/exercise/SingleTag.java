package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String nameTag, Map<String, String> dictionaryTag) {
        super(nameTag, dictionaryTag);
    }

    public String toString() {
        return getMaptoString();
    }
}
// END
