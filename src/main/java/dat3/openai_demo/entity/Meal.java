package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor @Getter @Setter @AllArgsConstructor

@Entity
@Table(name="Meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String mealType;
    String title;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    List<Ingredient> ingredients;

    String instructions;
    int calories;
    int protein;
    int carbs;
    int fat;


    public Meal(String mealType, String title, String instructions, int calories, int protein, int carbs, int fat) {
        this.mealType = mealType;
        this.title = title;
        this.instructions = instructions;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }
}
