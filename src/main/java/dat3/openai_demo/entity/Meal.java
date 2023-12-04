package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
    @Column(name = "meal_id", unique = true, nullable = false)
    private int id;

    private String mealType;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String instructions;
    @Column(columnDefinition = "TEXT")
    private String description;
    private int calories;
    private int carbs;
    private int fat;
    private int protein;
    private String timeToMake;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;
    @ManyToMany
    @JoinTable(
            name = "meal_ingredient", // Navnet på join-tabellen
            joinColumns = @JoinColumn(name = "meal_id"), // Kolonnen i join-tabellen, der refererer til `Meal id`
            inverseJoinColumns = @JoinColumn(name = "ingredient_id") // Kolonnen i join-tabellen, der refererer til `Ingredient`
    )
    private List<Ingredient> ingredients;


    public Meal(String mealType, String title, String instructions, int calories, int carbs, int fat, int protein) {
        this.mealType = mealType;
        this.title = title;
        this.instructions = instructions;
        this.calories = calories;
        this.carbs = carbs;
        this.fat = fat;
        this.protein = protein;
    }

    public void addIngredient(Ingredient i) {
        if(this.ingredients == null){
            this.ingredients = new ArrayList<>();
        }
         this.ingredients.add(i);
    }
}
