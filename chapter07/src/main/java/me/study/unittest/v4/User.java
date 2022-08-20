package me.study.unittest.v4;

import lombok.Getter;
import me.study.unittest.UserType;

@Getter
public class User {

    private int userId;
    private String email;
    private UserType type;

    public User(int userId, String email, UserType type) {
        this.userId = userId;
        this.email = email;
        this.type = type;
    }

    public void changeEmail(String newEmail, Company company) throws Exception {
        if (email.equals(newEmail)) {
            return;
        }

        UserType newType = company.isEmailCorporate(newEmail)
                           ? UserType.EMPLOYEE
                           : UserType.CUSTOMER;

        if (type != newType) {
            int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            company.changeNumberOfEmployees(delta);
        }

        email = newEmail;
        type = newType;
    }
}
