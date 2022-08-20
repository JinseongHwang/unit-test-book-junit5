package me.study.unittest.v5;

public class UserController {

    private final Database database = new Database();
    private final MessageBus messageBus = new MessageBus();

    public String changeEmail(int userId, String newEmail) throws Exception {
        final Object[] userData = database.getUserById(userId);
        final User user = UserFactory.create(userData);

        final String error = user.canChangeEmail();
        if (error != null) {
            return error;
        }

        final Object[] companyData = database.getCompany();
        final Company company = CompanyFactory.create(companyData);

        user.changeEmail(newEmail, company);

        database.saveCompany(company);
        database.saveUser(user);
        messageBus.sendEmailChangeMessage(userId, newEmail);

        return "OK";
    }
}
