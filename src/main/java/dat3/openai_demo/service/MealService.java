package dat3.openai_demo.service;

import dat3.openai_demo.dtos.SaveMealResponse;
import dat3.openai_demo.entity.Meal;
import dat3.openai_demo.entity.User;
import dat3.openai_demo.repository.MealRepository;
import dat3.openai_demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    private final MealRepository mealRepository;
    private final UserRepository userRepository;

    @Autowired
    public MealService(MealRepository mealRepository, UserRepository userRepository) {
        this.mealRepository = mealRepository;
        this.userRepository = userRepository;
    }

   public void saveMeal(Meal meal) {
        mealRepository.save(meal);
    }

        public void saveMealToUser (SaveMealResponse mealToSave){
            if (userRepository.findByUsername(mealToSave.getUsername())==null){
                throw new RuntimeException("User not found");
            }
            else{
                User user = userRepository.findByUsername(mealToSave.getUsername());
                Meal meal = new Meal();
                meal.setMealType(mealToSave.getMealType());
                meal.setTitle(mealToSave.getTitle());
                meal.setInstructions(mealToSave.getInstructions());
                meal.setCalories(mealToSave.getCalories());
                meal.setCarbs(mealToSave.getCarbohydrates());
                meal.setFat(mealToSave.getFat());
                meal.setProtein(mealToSave.getProtein());
                meal.setTimeToMake(mealToSave.getTimeToMake());
                meal.setDescription(mealToSave.getDescription());
                user.saveMeal(meal);
                mealRepository.save(meal);

            }
        }
    }
