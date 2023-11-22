package dat3.openai_demo.service;

import dat3.openai_demo.entity.Allergy;
import dat3.openai_demo.entity.User;
import dat3.openai_demo.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createUser(String username, int weight, int height, String sex, String activityLevel, String goals, List<Allergy> allergies) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setWeight(weight);
        newUser.setHeight(height);
        newUser.setSex(sex);
        newUser.setActivityLevel(activityLevel);
        newUser.setGoals(goals);
        newUser.setAllergies(allergies);
        return userRepository.save(newUser);
    }

}
