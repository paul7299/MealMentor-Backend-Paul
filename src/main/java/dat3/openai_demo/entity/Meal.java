package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Meal {
    @Id
    int mealId;
    String mealType;
    String title;
    @OneToMany(mappedBy = "ingredients")
    List<Ingredients> ingredients;
    String instructions;
    int calories;
    int protein;
    int carbs;
    int fat;
}
