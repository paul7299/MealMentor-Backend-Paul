package dat3.openai_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor @Getter @Setter @AllArgsConstructor

@Entity
@Table(name="Allergies")
public class Allergy {
    @Id
    String name;

    @ManyToMany(mappedBy = "allergies")
    List<User> users;

    public Allergy(String name) {
        this.name = name;
    }
}



