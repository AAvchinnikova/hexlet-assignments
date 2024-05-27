package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

// BEGIN
public class PairedTag extends Tag{
    private final String bodyTag;
    private final List<Tag> listChildrenTag;

    public PairedTag(String nameTag, Map<String, String> dictionaryTag, String bodyTag, List<Tag> listChildrenTag) {
        super(nameTag, dictionaryTag);
        this.bodyTag = bodyTag;
        this.listChildrenTag = listChildrenTag;
    }

    @Override
    public String toString() {
        String resultList = listChildrenTag.stream().map(value -> value.getMaptoString())
                .collect(Collectors.joining(""));
        if (listChildrenTag.isEmpty()) {
            return getMaptoString() + bodyTag + "</" + getNameTag() + ">";
        }
        return getMaptoString() + bodyTag + resultList
                + "</" + getNameTag() + ">";
    }
}
// END
