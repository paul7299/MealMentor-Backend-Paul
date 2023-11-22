package dat3.openai_demo.config;

import dat3.openai_demo.entity.Allergy;
import dat3.openai_demo.entity.User;
import dat3.openai_demo.repository.MealRepository;
import dat3.openai_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Arrays;
import java.util.List;

@Configurable
public class DeveloperData implements ApplicationRunner {
    MealRepository mealRepository;
    UserRepository userRepository;

    String passwordUsedByAll;

    public DeveloperData(MealRepository mealRepository, UserRepository userRepository) {
        this.mealRepository = mealRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        setupUsers();
    }

    private void setupUsers() {

        User user1 = new User("test1", 80, 180,null , "Male", "5", "Gain muscle");
        userRepository.saveAll(Arrays.asList(user1));
    }
}
