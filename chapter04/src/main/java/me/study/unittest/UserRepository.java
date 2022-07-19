package me.study.unittest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRepository {

    private String lastExecutedSqlStatement;

    public User getById(int id) {
        // execute SQL
        /**
         * Case 1) SELECT * FROM User WHERE id=5;
         * Case 2) SELECT id, name, email FROM User WHERE id=5;
         * Case 3) SELECT * FROM User WHERE id={id}
         */
        lastExecutedSqlStatement = "dummy SQL";
        return new User(); // dummy user for test
    }
}
