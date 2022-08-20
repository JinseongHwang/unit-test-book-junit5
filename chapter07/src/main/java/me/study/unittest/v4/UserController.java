package me.study.unittest.v4;

public class UserController {

    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public void changeEmail(int userId, String newEmail) throws Exception {
        Object[] userData = database.getUserById(userId);
        User user = UserFactory.create(userData);

        Object[] companyData = database.getCompany();
        Company company = CompanyFactory.create(companyData);

        user.changeEmail(newEmail, company);

        database.saveCompany(company);
        database.saveUser(user);
        messageBus.sendEmailChangeMessage(userId, newEmail);
    }
}
