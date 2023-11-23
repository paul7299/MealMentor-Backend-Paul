package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor @Getter @Setter @AllArgsConstructor

@Entity
@Table(name="Users")
public class User {
    @Id
    @Column(name="username_id", unique = true, nullable = false)
    String username;
    int weight;
    int height;
    @ManyToMany
    @JoinTable(
            name = "user_allergy", // Navnet på join-tabellen
            joinColumns = @JoinColumn(name = "username_id"), // Kolonnen i join-tabellen, der refererer til `User`
            inverseJoinColumns = @JoinColumn(name = "allergy_name") // Kolonnen i join-tabellen, der refererer til `Allergy`
    )
    List<Allergy> allergies;
    String sex;
    @Column(name="activity_level")
    String activityLevel;
    String goals;


}
