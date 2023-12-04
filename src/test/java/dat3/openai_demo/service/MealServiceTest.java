package dat3.openai_demo.service;

import dat3.openai_demo.TestUtils;
import dat3.openai_demo.entity.Meal;
import dat3.openai_demo.repository.IngredientRepository;
import dat3.openai_demo.repository.MealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MealServiceTest {
    @Autowired
    MealRepository mealRepository;
    MealService mealService;
    @Autowired
    IngredientRepository ingredientRepository;

    private boolean dataInitialized = false;

    @BeforeEach
    void setUp() {
        mealService = new MealService(mealRepository);
        if(!dataInitialized) {
            mealRepository.deleteAll();
            TestUtils.setupTestMeals(mealRepository, ingredientRepository);
            dataInitialized = true;
        }

    }

    @Test
    void getAllMeals() {
        List<Meal> meals = mealService.getAllMeals();
        assertEquals(2, meals.size());
    }


    @Test
    void saveMeal() {



    }
}