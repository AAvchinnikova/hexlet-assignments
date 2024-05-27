package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private final String nameTag;
    private final Map<String, String> dictionaryTag;

    public Tag(String nameTag, Map<String, String> dictionaryTag) {
        this.nameTag = nameTag;
        this.dictionaryTag = dictionaryTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public Map<String, String> getDictionaryTag() {
        return dictionaryTag;
    }
    public String getMaptoString (){
        String result = dictionaryTag.keySet().stream()
                .map(key -> key + "=" + "\"" + dictionaryTag.get(key) + "\"")
                .collect(Collectors.joining(" ")).toString();
        if (dictionaryTag.isEmpty()) {
            return "<" + nameTag + ">";
        }
        return "<" + nameTag + " " + result + ">";
    }

}
// END
