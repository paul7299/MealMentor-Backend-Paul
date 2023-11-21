package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    String username;
    int weight;
    int height;
    @ManyToMany
    List<Allergies> allergies;
    String sex;
    String activityLevel;
    String goals;
    @OneToMany(mappedBy = "user")
    List<Meal> meals;
}
