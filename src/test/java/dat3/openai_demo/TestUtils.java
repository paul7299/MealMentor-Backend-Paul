package dat3.openai_demo;

import dat3.openai_demo.entity.Allergy;
import dat3.openai_demo.entity.Ingredient;
import dat3.openai_demo.entity.Meal;
import dat3.openai_demo.entity.User;
import dat3.openai_demo.repository.AllergyRepository;
import dat3.openai_demo.repository.IngredientRepository;
import dat3.openai_demo.repository.MealRepository;
import dat3.openai_demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {
    public static void setupTestUsers(UserRepository userRepository, AllergyRepository allergyRepository){
        allergyRepository.deleteAll();
        Allergy peanutAllergy = new Allergy("Peanuts");
        allergyRepository.save(peanutAllergy);
        List<Allergy> allergies = new ArrayList<>();
        allergies.add(peanutAllergy);

        userRepository.deleteAll();
        String passwordUsedByAll = "password";

        User user1 = new User("testuser1", passwordUsedByAll, "testuser1@test.dk", 80,
                180, 80, 25, allergies, "Male", "Moderate", "Gain muscle");
        User user2 = new User("testuser2", passwordUsedByAll, "testuser2@test.dk", 90,
                200, 50, 0, allergies, "Male", "No excercise", "Lose weight");

        userRepository.save(user1);
        userRepository.save(user2);
    }

    public static void setupTestMeals(
            MealRepository mealRepository,
            IngredientRepository ingredientRepository){

        mealRepository.deleteAll();
        Meal meal1 = new Meal("breakfast", "tomato breakfast", "bake it", 100, 50, 200, 10);
        Meal meal2 = new Meal("lunch", "banana lunch", "eat it raw", 100, 50, 200, 10);

        Ingredient ingredient = new Ingredient("1 Tomato");
        Ingredient ingredient2 = new Ingredient("Bananas");
        Ingredient ingredient3 = new Ingredient("1 Tomato");
        ingredientRepository.save(ingredient);
        ingredientRepository.save(ingredient2);
        ingredientRepository.save(ingredient3);

        List<Ingredient> ingToMeal1 = new ArrayList<>();
        ingToMeal1.add(ingredient);
        ingToMeal1.add(ingredient2);

        List<Ingredient> ingToMeal2 = new ArrayList<>();
        ingToMeal2.add(ingredient3);

        meal1.setIngredients(ingToMeal1);
        meal2.setIngredients(ingToMeal2);

        mealRepository.saveAll(Arrays.asList(meal1, meal2));


    }

}
