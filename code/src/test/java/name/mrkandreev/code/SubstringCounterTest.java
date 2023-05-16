package name.mrkandreev.code;

import name.mrkandreev.code.IndexOfSubstringCounterImpl;
import name.mrkandreev.code.IndexOfWithJumpSubstringCounterImpl;
import name.mrkandreev.code.RegExSubstringCounterImpl;
import name.mrkandreev.code.ReplaceBasedSubstringCounterImpl;
import name.mrkandreev.code.SubstringCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstringCounterTest {
    @ParameterizedTest
    @MethodSource("getImpls")
    void shouldReturnZeroIfNoSubstringPresent(SubstringCounter counter) {
        assertEquals(0, counter.count("abcd", "x"));
    }

    @ParameterizedTest
    @MethodSource("getImpls")
    void shouldReturnOneIfStringEqualsToString(SubstringCounter counter) {
        assertEquals(1, counter.count("abcd", "abcd"));
    }

    @ParameterizedTest
    @MethodSource("getImpls")
    void shouldReturnOneIfStringContainsSingleSubstring(SubstringCounter counter) {
        assertEquals(1, counter.count("abcd", "bc"));
    }

    @ParameterizedTest
    @MethodSource("getImpls")
    void shouldReturnMultipleSubstring(SubstringCounter counter) {
        assertEquals(3, counter.count("abxxabxab", "ab"));
    }

    static Stream<Arguments> getImpls() {
        return Stream.of(
                Arguments.of(new IndexOfSubstringCounterImpl()),
                Arguments.of(new IndexOfWithJumpSubstringCounterImpl()),
                Arguments.of(new ReplaceBasedSubstringCounterImpl()),
                Arguments.of(new RegExSubstringCounterImpl())
        );
    }
}
