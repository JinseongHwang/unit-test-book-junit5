package me.study.unittest;

public class Example5_05 {

    class User {

        public String name;

        public String normalizeName(String name) {
            final String result = name.strip();

            if (result.length() > 50) {
                return result.substring(0, 50);
            }
            return result;
        }
    }

    class UserController {

        public void renameUser(int userId, String newName) {
            final User user = getUserFromDatabase(userId);

            final String normalizedName = user.normalizeName(newName);
            user.name = normalizedName;

            saveUserToDatabase(user);
        }

        private void saveUserToDatabase(User user) {
        }

        private User getUserFromDatabase(int userId) {
            return new User();
        }
    }

}
