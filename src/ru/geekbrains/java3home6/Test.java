package ru.geekbrains.java3home6;
import myArrays.MyArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

    public class MyArraysTests {

        @Order(1)
        @ParameterizedTest
        @MethodSource("valuesProvider2")
        void shouldFindNumbersAfterLastFourAtArray(int[] expected, int[] array) {
            Assertions.assertArrayEquals(expected, Arr.findNumbersAfterLastFourAtArray(array));
        }
        private static Stream<Arguments> valuesProvider2() {
            return Stream.of(
                    Arguments.arguments(new int[]{8, 9, 0}, new int[]{2, 4, 8, 9, 0}),
                    Arguments.arguments(new int[]{9}, new int[]{1, 4, 0, 4, 9}),
                    Arguments.arguments(new int[]{3, 6, 6, 5}, new int[]{4, 3, 6, 6, 5})
            );
        }

        @Order(2)
        @Test
        void shouldThrowRuntimeExceptionInMyArraysFindNumbersAfterLastFourAtArray() {
            Assertions.assertThrows(RuntimeException.class, () -> {
                Arr.findNumbersAfterLastFourAtArray(new int[]{3, 2, 3, 7, 1});
            });
        }

        @Order(3)
        @ParameterizedTest
        @MethodSource("valuesProvider")
        void shouldCheckArrayForOneAndFour(boolean expected, int[] array) {
            Assertions.assertEquals(expected, Arr.checkArrayForOneAndFour(array));
        }

        private static Stream<Arguments> valuesProvider() {
            return Stream.of(
                    Arguments.arguments(true, new int[]{3, 2, 3, 7, 1}),
                    Arguments.arguments(true, new int[]{2, 4, 8, 9, 0}),
                    Arguments.arguments(true, new int[]{1, 4, 4, 8, 9}),
                    Arguments.arguments(false, new int[]{6, 5, 8, 0, 0}),
                    Arguments.arguments(false, new int[]{2, 3, 6, 6, 5})
            );
        }

    }
