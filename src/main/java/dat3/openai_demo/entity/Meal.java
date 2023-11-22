package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="meal_id", unique = true, nullable = false)
    private int id;

    String mealType;
    String title;
    String instructions;
    int calories;
    int carbs;
    int fat;
    int protein;

    @ManyToMany
    @JoinTable(
            name = "meal_ingredient", // Navnet på join-tabellen
            joinColumns = @JoinColumn(name = "meal_id"), // Kolonnen i join-tabellen, der refererer til `Meal id`
            inverseJoinColumns = @JoinColumn(name = "ingredient_name") // Kolonnen i join-tabellen, der refererer til `Ingredient`
    )
    List<Ingredient> ingredients;

    public Meal(String mealType, String title, String instructions, int calories, int carbs, int fat, int protein) {
        this.mealType = mealType;
        this.title = title;
        this.instructions = instructions;
        this.calories = calories;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
    }
}
