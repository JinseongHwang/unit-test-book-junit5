package me.study.unittest.v2;

import me.study.unittest.UserType;

public class UserController {

    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public void changeEmail(int userId, String newEmail) {
        final Object[] data = database.getUserById(userId);
        final String email = (String)data[1];
        final UserType type = (UserType)data[2];
        final User user = new User(userId, email, type);

        final Object[] companyData = database.getCompany();
        final String companyDomainName = (String)companyData[0];
        final int numberOfEmployees = (int)companyData[1];

        final int newNumberOfEmployees = user.changeEmail(newEmail, companyDomainName, numberOfEmployees);

        database.saveCompany(newNumberOfEmployees);
        database.saveUser(user);
        messageBus.sendEmailChangeMessage(userId, newEmail);
    }

}
