package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class AssertAllTests {

    final int actual = 42;
    final int expected = 1;

    @Test
    void junit5() {
        var comparisonFailure = assertThrowsExactly(org.opentest4j.MultipleFailuresError.class, () ->
                Assertions.assertAll(
                        () -> Assertions.assertEquals(42, 1),
                        () -> Assertions.assertEquals(43, 1)
                )
        );
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("""
                        Multiple Failures (2 failures)
                        \torg.opentest4j.AssertionFailedError: expected: <42> but was: <1>
                        \torg.opentest4j.AssertionFailedError: expected: <43> but was: <1>""");;
    }

}
