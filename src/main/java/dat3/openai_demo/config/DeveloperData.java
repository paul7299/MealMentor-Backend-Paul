package dat3.openai_demo.config;

import dat3.openai_demo.entity.Allergy;
import dat3.openai_demo.entity.Ingredient;
import dat3.openai_demo.entity.Meal;
import dat3.openai_demo.entity.User;
import dat3.openai_demo.repository.AllergyRepository;
import dat3.openai_demo.repository.IngredientRepository;
import dat3.openai_demo.repository.MealRepository;
import dat3.openai_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {
    MealRepository mealRepository;
    UserRepository userRepository;
    AllergyRepository allergyRepository;
    IngredientRepository ingredientRepository;

    String passwordUsedByAll;


    public DeveloperData(MealRepository mealRepository, UserRepository userRepository, AllergyRepository allergyRepository, IngredientRepository ingredientRepository) {
        this.mealRepository = mealRepository;
        this.userRepository = userRepository;
        this.allergyRepository = allergyRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        setupUsers();
        setupTestMeals();
    }

    private void setupUsers() {

        Allergy peanutAllergy = new Allergy("Peanuts");
        Allergy fishAllergy = new Allergy("Fish");
        Allergy dairyAllergy = new Allergy("Dairy");

        allergyRepository.save(peanutAllergy);
        allergyRepository.save(fishAllergy);
        allergyRepository.save(dairyAllergy);

        // TODO list burde være den type som kun kan tage en unikk

        List<Allergy> allergies = new ArrayList<Allergy>();
        allergies.add(peanutAllergy);

        List<Allergy> allergies2 = new ArrayList<Allergy>();
        allergies2.add(peanutAllergy);
        allergies2.add(fishAllergy);

        User user1 = new User("testuser1", 80, 180, allergies, "Male", "Moderate", "Gain muscle");
        User user2 = new User("testuser2", 50, 200, allergies2, "Male", "No excercise", "Lose weight");


        userRepository.saveAll(Arrays.asList(user1, user2));

    }


    private void setupTestMeals() {

        Meal meal1 = new Meal("breakfast", "tomato breakfast", "bake it", 100, 50, 200, 10);
        Meal meal2 = new Meal("lunch", "banana lunch", "eat it raw", 100, 50, 200, 10);

        mealRepository.saveAll(Arrays.asList(meal1, meal2));

        Ingredient ingredient = new Ingredient("1 Tomato", meal1);
        Ingredient ingredient2 = new Ingredient("2 Bananas", meal2);
        Ingredient ingredient3 = new Ingredient("1 Tomato", meal2);

        ingredientRepository.save(ingredient);
        ingredientRepository.save(ingredient2);
        ingredientRepository.save(ingredient3);



    }

}
