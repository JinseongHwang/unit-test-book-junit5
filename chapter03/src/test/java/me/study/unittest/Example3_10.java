package me.study.unittest;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class Example3_10 {

    @Test
    public void Delivery_with_a_past_date_is_invalid() {
        // Given
        final DeliveryService sut = new DeliveryService();
        final LocalDateTime pastDate = LocalDateTime.now().minusDays(1L);
        final Delivery delivery = new Delivery(pastDate);

        // When
        final boolean isValid = sut.isDeliveryValid(delivery);

        // Then
        assertFalse(isValid);
    }
}
