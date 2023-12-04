package dat3.openai_demo;

import dat3.openai_demo.entity.User;
import dat3.openai_demo.repository.AllergyRepository;
import dat3.openai_demo.repository.UserRepository;

public class TestUtils {
    public static void setupTestUsers(UserRepository userRepository){
        userRepository.deleteAll();
        String passwordUsedByAll = "password";
        User user1 = new User("testuser1", passwordUsedByAll, "testuser1@test.dk", 80,
                180, 80, 25, null, "Male", "Moderate", "Gain muscle");
        User user2 = new User("testuser2", passwordUsedByAll, "testuser2@test.dk", 90,
                200, 50, 0, null, "Male", "No excercise", "Lose weight");

        userRepository.save(user1);
        userRepository.save(user2);
    }
}
