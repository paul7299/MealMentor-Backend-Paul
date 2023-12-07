package dat3.openai_demo.dtos;

import dat3.openai_demo.entity.Meal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MealResponse {
    private int mealId;
    private String mealType;
    private String title;
    private String instructions;
    private String description;
    private int calories;
    private int protein;
    private int carbs;
    private int fat;
    private String timeToMake;

  public MealResponse(Meal meal){
    this.mealId = meal.getId();
    this.mealType = meal.getMealType();
    this.title = meal.getTitle();
    this.instructions = meal.getInstructions();
    this.description = meal.getDescription();
    this.calories = meal.getCalories();
    this.protein = meal.getProtein();
    this.carbs = meal.getCarbs();
    this.fat = meal.getFat();
    this.timeToMake = meal.getTimeToMake();
  }
}