package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Example3_13 {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void Can_detect_an_invalid_delivery_date(
        LocalDateTime deliveryDate, boolean expected
    ) {
        // Given
        final DeliveryService sut = new DeliveryService();
        final Delivery delivery = new Delivery(deliveryDate);

        // When
        final boolean isValid = sut.isDeliveryValid(delivery);

        // Then
        assertSame(expected, isValid);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(LocalDateTime.now().minusDays(1L), false),
            Arguments.of(LocalDateTime.now(), false),
            Arguments.of(LocalDateTime.now().plusDays(1L), false),
            Arguments.of(LocalDateTime.now().plusDays(2L), true)
        );
    }
}
