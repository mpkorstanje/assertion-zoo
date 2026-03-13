package com.example;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.ValueWrapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class ShortCollectionTests {

    final List<String> actual = List.of(
            "a",
            "b",
            "c",
            "d",
            "a",
            "b",
            "c",
            "d",
            "a",
            "b",
            "c",
            "d"
    );
    final List<String> expected = List.of(
            "b",
            "c",
            "d",
            "e",
            "b",
            "c",
            "d",
            "e",
            "b",
            "c",
            "d",
            "e",
            "b",
            "c",
            "d",
            "e"
    );



    @Test
    void assertJ3() {
        var comparisonFailure = assertThrowsExactly(AssertionFailedError.class, () -> org.assertj.core.api.Assertions.assertThat(actual).isEqualTo(expected));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("""
                        
                        expected: ["b", "c", "d", "e", "b", "c", "d", "e", "b", "c", "d", "e", "b", "c", "d", "e"]
                         but was: ["a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d"]""");


        assertThat(comparisonFailure)
                .extracting(AssertionFailedError::getActual)
                .extracting(ValueWrapper::getStringRepresentation)
                .isEqualTo("""
                        ["a", "b", "c", "d", "a", "b", "c", "d", "a", "b", "c", "d"]""");
        assertThat(comparisonFailure)
                .extracting(AssertionFailedError::getExpected)
                .extracting(ValueWrapper::getStringRepresentation)
                .isEqualTo("""
                        ["b", "c", "d", "e", "b", "c", "d", "e", "b", "c", "d", "e", "b", "c", "d", "e"]""");
    }

}
