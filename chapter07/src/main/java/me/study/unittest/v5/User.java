package me.study.unittest.v5;

import lombok.Getter;
import me.study.unittest.UserType;

@Getter
public class User {

    private int userId;
    private String email;
    private UserType type;
    private boolean isEmailConfirmed;

    public User(int userId, String email, UserType type, boolean isEmailConfirmed) {
        this.userId = userId;
        this.email = email;
        this.type = type;
        this.isEmailConfirmed = isEmailConfirmed;
    }

    public String canChangeEmail() {
        if (isEmailConfirmed) {
            return "Can't change email after it's confirmed";
        }
        return null;
    }

    public void changeEmail(String newEmail, Company company) throws Exception {
        Precondition.requires(canChangeEmail() == null);

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
