package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

public class ReverseTest {

    @Test
    void ReverseTest() {
        var ectual = "ABCD";
        var expected = "DCBA";
        assertThat(ReversedSequence.reversedSequence(ectual)).isEqualTo(expected);
    }
}
