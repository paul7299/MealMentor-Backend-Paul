package dat3.openai_demo.dtos;

import dat3.openai_demo.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SaveMealResponse {

    private String mealType;
    private String title;
    private String instructions;
    private ArrayList<String> ingredients;
    private int calories;
    private int carbohydrates;
    private int fat;
    private int protein;
    private String timeToMake;
    private String description;
    private String username;

}
