package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split 테스트")
    public void testSplitTest() {

        String s = "1,2";
        String regex = ",";
        String[] split = s.split(regex);

        assertThat(split[0]).isEqualTo("1");
        assertThat(split[1]).isEqualTo("2");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
        assertThat(split).containsOnly("2", "1");
    }

    @Test
    @DisplayName("replace 테스트")
    public void testReplaceTest() {

        String s = "(1,2)";
        String substring = s.substring(1, 4);

        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt exception 테스트")
    public void testCharAtExceptionTest() {

        assertThatThrownBy(() -> {
            String s = "abc";
            s.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
