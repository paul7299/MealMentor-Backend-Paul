package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor @Getter @Setter @AllArgsConstructor

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int mealId;
    String mealType;
    String title;
    //@OneToMany(mappedBy = "meal")
    //List<Ingredients> ingredients;
    String instructions;
    int calories;
    int protein;
    int carbs;
    int fat;
}
