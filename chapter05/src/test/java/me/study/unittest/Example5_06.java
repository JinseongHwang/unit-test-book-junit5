package me.study.unittest;

public class Example5_06 {

    class User {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = normalizeName(name);
        }

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
            user.setName(newName);
            saveUserToDatabase(user);
        }

        private void saveUserToDatabase(User user) {
        }

        private User getUserFromDatabase(int userId) {
            return new User();
        }
    }

}
