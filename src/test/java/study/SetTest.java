package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case
    @Test
    @DisplayName("set size 체크")
    public void testSetSize() {

        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.contains(1)).isTrue();
    }

    @DisplayName("값 존재여부 체크 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testContains(int input) {
        assertTrue(numbers.contains(input));
    }

    @DisplayName("값 존재여부 체크 여러개 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    public void testContainsForEach(int input, String expected) {
        assertEquals(numbers.contains(input), Boolean.parseBoolean(expected));
    }


}
