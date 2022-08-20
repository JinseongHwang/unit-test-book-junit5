package me.study.unittest.v3;

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

    public int changeEmail(String newEmail, String companyDomainName, int numberOfEmployees) {
        if (this.email.equals(newEmail)) {
            return numberOfEmployees;
        }

        final String emailDomain = newEmail.split("@")[1];
        final boolean isEmailCorporate = emailDomain.equals(companyDomainName);
        final UserType newType = isEmailCorporate
                                 ? UserType.EMPLOYEE
                                 : UserType.CUSTOMER;

        if (this.type != newType) {
            final int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            final int newNumber = numberOfEmployees + delta;
            numberOfEmployees = newNumber;
        }

        this.email = newEmail;
        this.type = newType;

        return numberOfEmployees;
    }
}
