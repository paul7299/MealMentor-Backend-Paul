package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor @Getter @Setter @AllArgsConstructor

@Entity
public class User {
    @Id
    String username;
    int weight;
    int height;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    List<Allergy> allergies;
    String sex;
    @Column(name="activity_level")
    String activityLevel;
    String goals;

}
