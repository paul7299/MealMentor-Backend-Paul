package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "allergies")
public class Allergy {
    @Id
    @Column(name="allergy_name", unique = true, nullable = false)
    String name;

    @ManyToMany
    List<User> users;

    public Allergy(String name) {
        this.name = name;
    }
}



