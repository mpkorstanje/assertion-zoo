package com.example;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.ValueWrapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class LargeCollectionTests {

    final List<String> actual = List.of(
            "aaaaaaaaaaaaaaaaaaa",
            "bbbbbbbbbbbbbbbbbbb",
            "ccccccccccccccccccc",
            "ddddddddddddddddddd",
            "aaaaaaaaaaaaaaaaaaa",
            "bbbbbbbbbbbbbbbbbbb",
            "ccccccccccccccccccc",
            "ddddddddddddddddddd",
            "aaaaaaaaaaaaaaaaaaa",
            "bbbbbbbbbbbbbbbbbbb",
            "ccccccccccccccccccc",
            "ddddddddddddddddddd"
    );
    final List<String> expected = List.of(
            "bbbbbbbbbbbbbbbbbbb",
            "ccccccccccccccccccc",
            "ddddddddddddddddddd",
            "eeeeeeeeeeeeeeeeeee",
            "bbbbbbbbbbbbbbbbbbb",
            "ccccccccccccccccccc",
            "ddddddddddddddddddd",
            "eeeeeeeeeeeeeeeeeee",
            "bbbbbbbbbbbbbbbbbbb",
            "ccccccccccccccccccc",
            "ddddddddddddddddddd",
            "eeeeeeeeeeeeeeeeeee",
            "bbbbbbbbbbbbbbbbbbb",
            "ccccccccccccccccccc",
            "ddddddddddddddddddd",
            "eeeeeeeeeeeeeeeeeee"
    );



    @Test
    void assertJ3() {
        var comparisonFailure = assertThrowsExactly(org.opentest4j.AssertionFailedError.class, () -> org.assertj.core.api.Assertions.assertThat(actual).isEqualTo(expected));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("""
                        
                        expected:\s
                          ["bbbbbbbbbbbbbbbbbbb",
                              "ccccccccccccccccccc",
                              "ddddddddddddddddddd",
                              "eeeeeeeeeeeeeeeeeee",
                              "bbbbbbbbbbbbbbbbbbb",
                              "ccccccccccccccccccc",
                              "ddddddddddddddddddd",
                              "eeeeeeeeeeeeeeeeeee",
                              "bbbbbbbbbbbbbbbbbbb",
                              "ccccccccccccccccccc",
                              "ddddddddddddddddddd",
                              "eeeeeeeeeeeeeeeeeee",
                              "bbbbbbbbbbbbbbbbbbb",
                              "ccccccccccccccccccc",
                              "ddddddddddddddddddd",
                              "eeeeeeeeeeeeeeeeeee"]
                         but was:\s
                          ["aaaaaaaaaaaaaaaaaaa",
                              "bbbbbbbbbbbbbbbbbbb",
                              "ccccccccccccccccccc",
                              "ddddddddddddddddddd",
                              "aaaaaaaaaaaaaaaaaaa",
                              "bbbbbbbbbbbbbbbbbbb",
                              "ccccccccccccccccccc",
                              "ddddddddddddddddddd",
                              "aaaaaaaaaaaaaaaaaaa",
                              "bbbbbbbbbbbbbbbbbbb",
                              "ccccccccccccccccccc",
                              "ddddddddddddddddddd"]""");


        assertThat(comparisonFailure)
                .extracting(AssertionFailedError::getActual)
                .extracting(ValueWrapper::getStringRepresentation)
                .isEqualTo("""
                        ["aaaaaaaaaaaaaaaaaaa",
                            "bbbbbbbbbbbbbbbbbbb",
                            "ccccccccccccccccccc",
                            "ddddddddddddddddddd",
                            "aaaaaaaaaaaaaaaaaaa",
                            "bbbbbbbbbbbbbbbbbbb",
                            "ccccccccccccccccccc",
                            "ddddddddddddddddddd",
                            "aaaaaaaaaaaaaaaaaaa",
                            "bbbbbbbbbbbbbbbbbbb",
                            "ccccccccccccccccccc",
                            "ddddddddddddddddddd"]
                        """);
        assertThat(comparisonFailure)
                .extracting(AssertionFailedError::getExpected)
                .extracting(ValueWrapper::getStringRepresentation)
                .isEqualTo("""
                        ["aaaaaaaaaaaaaaaaaaa",
                            "bbbbbbbbbbbbbbbbbbb",
                            "ccccccccccccccccccc",
                            "ddddddddddddddddddd",
                            "aaaaaaaaaaaaaaaaaaa",
                            "bbbbbbbbbbbbbbbbbbb",
                            "ccccccccccccccccccc",
                            "ddddddddddddddddddd",
                            "aaaaaaaaaaaaaaaaaaa",
                            "bbbbbbbbbbbbbbbbbbb",
                            "ccccccccccccccccccc",
                            "ddddddddddddddddddd"]""");
    }

}
