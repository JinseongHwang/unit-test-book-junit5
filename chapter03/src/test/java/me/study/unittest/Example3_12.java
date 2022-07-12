package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Example3_12 {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void Can_detect_an_invalid_delivery_date(
        int daysFromNow, boolean expected
    ) {
        // Given
        final DeliveryService sut = new DeliveryService();
        final LocalDateTime deliveryDate = LocalDateTime.now().plusDays(daysFromNow);
        final Delivery delivery = new Delivery(deliveryDate);

        // When
        final boolean isValid = sut.isDeliveryValid(delivery);

        // Then
        assertSame(expected, isValid);
    }

    @Test
    public void The_soonest_delivery_date_is_two_days_from_now() {
        // Given
        final DeliveryService sut = new DeliveryService();
        final LocalDateTime deliveryDate = LocalDateTime.now().plusDays(2L);
        final Delivery delivery = new Delivery(deliveryDate);

        // When
        final boolean isValid = sut.isDeliveryValid(delivery);

        // Then
        assertTrue(isValid);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(-1, false),
            Arguments.of(0, false),
            Arguments.of(1, false)
        );
    }
}
