package dat3.openai_demo.service;

import dat3.openai_demo.entity.Meal;
import dat3.openai_demo.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    private final MealRepository mealRepository;

    @Autowired
    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void saveMeal(Meal meal) {
        mealRepository.save(meal);
    }
}
