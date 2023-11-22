/*package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor @Getter @Setter @AllArgsConstructor

@Entity
@Table(name="ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @ManyToOne
    @JoinColumn(name = "meal_id") // Specify the name of the foreign key column
    private Meal meal;


    public Ingredient(String name, Meal meal) {
        this.name = name;
        this.meal = meal;
    }
}
*/