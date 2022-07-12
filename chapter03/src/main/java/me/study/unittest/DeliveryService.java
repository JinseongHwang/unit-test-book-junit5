package me.study.unittest;

import java.time.LocalDateTime;

public class DeliveryService {

    public boolean isDeliveryValid(Delivery delivery) {
        final LocalDateTime deliveryDate = delivery.getDate();
        // C# 표현으로는 1.999일을 더하라고 되어있지만, 나는 Java로 2일에서 1분을 빼는 식으로 표현했다.
        final LocalDateTime maxValidDate = LocalDateTime.now().plusMinutes(2 * 24 * 60 - 1);
        return deliveryDate.isEqual(maxValidDate) || deliveryDate.isAfter(maxValidDate);
    }
}
