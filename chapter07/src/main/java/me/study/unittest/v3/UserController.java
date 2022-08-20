package me.study.unittest.v3;

public class UserController {

    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public void changeEmail(int userId, String newEmail) throws Exception {
        final Object[] userData = database.getUserById(userId);
        final User user = UserFactory.create(userData);

        final Object[] companyData = database.getCompany();
        final String companyDomainName = (String)companyData[0];
        final int numberOfEmployees = (int)companyData[1];

        final int newNumberOfEmployees = user.changeEmail(newEmail, companyDomainName, numberOfEmployees);

        database.saveCompany(newNumberOfEmployees);
        database.saveUser(user);
        messageBus.sendEmailChangeMessage(userId, newEmail);
    }
}
