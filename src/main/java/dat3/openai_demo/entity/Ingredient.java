package dat3.openai_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor @Getter @Setter @AllArgsConstructor

// @Entity
public class Ingredient {
    @Id
    String name;
    @ManyToOne
    Meal meal;
}
