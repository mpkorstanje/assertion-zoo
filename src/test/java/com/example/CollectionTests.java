package com.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.ValueWrapper;
import org.testng.Assert;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class CollectionTests {

    final List<String> actual = List.of("a", "b", "c", "d");
    final List<String> expected = List.of("b", "c", "d", "e");

    @Test
    void hamcrest3() {
        var comparisonFailure = assertThrowsExactly(AssertionError.class, () -> MatcherAssert.assertThat(actual, IsEqual.equalTo(expected)));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("""
                        
                        Expected: <[b, c, d, e]>
                             but: was <[a, b, c, d]>""");
    }

    @Test
    void assertJ3() {
        var comparisonFailure = assertThrowsExactly(org.opentest4j.AssertionFailedError.class, () -> org.assertj.core.api.Assertions.assertThat(actual).isEqualTo(expected));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("""
                        
                        expected: ["b", "c", "d", "e"]
                         but was: ["a", "b", "c", "d"]""");

        assertThat(comparisonFailure)
                .extracting(AssertionFailedError::getActual)
                .extracting(ValueWrapper::getStringRepresentation)
                .isEqualTo("""
                        ["a", "b", "c", "d"]""");

        assertThat(comparisonFailure)
                .extracting(AssertionFailedError::getExpected)
                .extracting(ValueWrapper::getStringRepresentation)
                .isEqualTo("""
                        ["b", "c", "d", "e"]""");

    }

    @Test
    void junit5() {
        var comparisonFailure = assertThrowsExactly(org.opentest4j.AssertionFailedError.class, () -> Assertions.assertEquals(expected, actual));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("expected: <[b, c, d, e]> but was: <[a, b, c, d]>");;

        assertThat(comparisonFailure)
                .extracting(AssertionFailedError::getActual)
                .extracting(ValueWrapper::getStringRepresentation)
                .isEqualTo("""
                        [a, b, c, d]""");

        assertThat(comparisonFailure)
                .extracting(AssertionFailedError::getExpected)
                .extracting(ValueWrapper::getStringRepresentation)
                .isEqualTo("""
                        [b, c, d, e]""");
    }

    @Test
    void junit4() {
        var comparisonFailure = assertThrowsExactly(AssertionError.class, () -> org.junit.Assert.assertEquals(expected, actual));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("expected:<[b, c, d, e]> but was:<[a, b, c, d]>");;
    }

    @Test
    void testng7() {
        var comparisonFailure = assertThrowsExactly(AssertionError.class, () -> Assert.assertEquals(actual, expected));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("Lists differ at element [0]: b != a expected [b] but found [a]");;
    }

    @Test
    void truth14() {
        var comparisonFailure = assertThrows(AssertionError.class, () -> com.google.common.truth.Truth.assertThat(actual).isEqualTo(expected));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("""
                        missing (1)   : e
                        unexpected (1): a
                        ---
                        expected      : [b, c, d, e]
                        but was       : [a, b, c, d]""");
    }

}
