package com.example;

import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LongStringTests {


    final String expected = """
            {
                "greeting": "hello",
                "audience": "world
                "scores: [
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a"
                ]
            }
            """;

    final String actual = """
            {
                "greeting": "hello",
                "stage": "world
                "scores: [
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a"
                ]
            }
            """;

    @Test
    void assertJ3(){
        var comparisonFailure = assertThrows(AssertionFailedError.class, () -> assertThat(actual).isEqualTo(expected));
        assertThat(comparisonFailure).hasMessage("""
                
                expected:\s
                  "{
                      "greeting": "hello",
                      "audience": "world
                      "scores: [
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a"
                      ]
                  }
                  "
                 but was:\s
                  "{
                      "greeting": "hello",
                      "stage": "world
                      "scores: [
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a",
                          "a"
                      ]
                  }
                  \"""");
    }

    @Test
    void junit5(){
        var comparisonFailure = assertThrows(AssertionFailedError.class, () -> org.junit.jupiter.api.Assertions.assertEquals(expected, actual));

        assertThat(comparisonFailure).hasMessage("""
            expected: <{
                "greeting": "hello",
                "audience": "world
                "scores: [
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a"
                ]
            }
            > but was: <{
                "greeting": "hello",
                "stage": "world
                "scores: [
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a"
                ]
            }
            >""");


    }

    @Test
    void testng7() {
        var comparisonFailure = assertThrows(AssertionError.class, () -> org.testng.Assert.assertEquals(actual, expected));
        assertThat(comparisonFailure).hasMessage("""
            expected [{
                "greeting": "hello",
                "audience": "world
                "scores: [
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a"
                ]
            }
            ] but found [{
                "greeting": "hello",
                "stage": "world
                "scores: [
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a",
                    "a"
                ]
            }
            ]""");

    }

    @Test
    void truth14() {
        var comparisonFailure = assertThrows(AssertionError.class, () -> com.google.common.truth.Truth.assertThat(actual).isEqualTo(expected));
        assertThat(comparisonFailure).hasMessage("""
            diff (-expected +actual):
                @@ -1,6 +1,6 @@
                 {
                     "greeting": "hello",
                -    "audience": "world
                +    "stage": "world
                     "scores: [
                         "a",
                         "a",""");
    }
}
