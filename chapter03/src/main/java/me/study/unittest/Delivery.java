package me.study.unittest;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Delivery {

    private LocalDateTime date;

    public Delivery(LocalDateTime date) {
        this.date = date;
    }
}
