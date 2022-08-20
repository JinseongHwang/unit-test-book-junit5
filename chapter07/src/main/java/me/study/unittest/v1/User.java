package me.study.unittest.v1;

import lombok.Getter;
import me.study.unittest.UserType;

@Getter
public class User {

    private int userId;
    private String email;
    private UserType type;

    public void changeEmail(int userId, String newEmail) {
        final Object[] data = Database.getUserById(userId);
        this.userId = userId;
        this.email = (String)data[1];
        this.type = (UserType)data[2];

        if (this.email.equals(newEmail)) {
            return;
        }

        final Object[] companyData = Database.getCompany();
        final String companyDomainName = (String)companyData[0];
        final int numberOfEmployees = (int)companyData[1];

        final String emailDomain = newEmail.split("@")[1];
        final boolean isEmailCorporate = emailDomain.equals(companyDomainName);
        final UserType newType = isEmailCorporate
                                 ? UserType.EMPLOYEE
                                 : UserType.CUSTOMER;

        if (this.type != newType) {
            final int delta = newType == UserType.EMPLOYEE ? 1 : -1;
            final int newNumber = numberOfEmployees + delta;
            Database.saveCompany(newNumber);
        }

        this.email = newEmail;
        this.type = newType;

        Database.saveUser(this);
        MessageBus.sendEmailChangeMessage(this.userId, newEmail);
    }
}
