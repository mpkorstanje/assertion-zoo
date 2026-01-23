package com.example;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class IntegerTests {

    final int actual = 42;
    final int expected = 1;

    @Test
    void hamcrest3() {
        var comparisonFailure = assertThrowsExactly(AssertionError.class, () -> MatcherAssert.assertThat(actual, IsEqual.equalTo(expected)));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("""
                        
                        Expected: <1>
                             but: was <42>""");
    }

    @Test
    void assertJ3() {
        var comparisonFailure = assertThrowsExactly(org.opentest4j.AssertionFailedError.class, () -> org.assertj.core.api.Assertions.assertThat(actual).isEqualTo(expected));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("""
                        
                        expected: 1
                         but was: 42""");;
    }

    @Test
    void junit5() {
        var comparisonFailure = assertThrowsExactly(org.opentest4j.AssertionFailedError.class, () -> Assertions.assertEquals(expected, actual));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("expected: <1> but was: <42>");;
    }

    @Test
    void junit4() {
        var comparisonFailure = assertThrowsExactly(AssertionError.class, () -> org.junit.Assert.assertEquals(expected, actual));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("expected:<1> but was:<42>");;
    }

    @Test
    void testng7() {
        var comparisonFailure = assertThrowsExactly(AssertionError.class, () -> Assert.assertEquals(actual, expected));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("expected [1] but found [42]");;
    }

    @Test
    void truth14() {
        var comparisonFailure = assertThrows(org.junit.ComparisonFailure.class, () -> com.google.common.truth.Truth.assertThat(actual).isEqualTo(expected));
        assertThat(comparisonFailure).isNotNull()
                .hasMessage("""
                        expected: 1
                        but was : 42""");
    }

}
