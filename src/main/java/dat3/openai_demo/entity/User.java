package dat3.openai_demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import dat3.security.entity.UserWithRoles;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor @Getter @Setter @AllArgsConstructor

@Entity
@Table(name="Users")
public class User extends UserWithRoles {

    int weight;
    int height;
    int age;
    int credits;
    @ManyToMany
    @JoinTable(
            name = "user_allergy", // Navnet på join-tabellen
            joinColumns = @JoinColumn(name = "username_id"), // Kolonnen i join-tabellen, der refererer til `User`
            inverseJoinColumns = @JoinColumn(name = "allergy_name") // Kolonnen i join-tabellen, der refererer til `Allergy`
    )
    @JsonIgnoreProperties("users")
    List<Allergy> allergies;
    String sex;
    @Column(name="activity_level")
    String activityLevel;
    String goals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Meal> savedMeals;

    public User(String username, String password, String email,
                int weight, int height, int age, int credits,
                List<Allergy> allergies, String sex,
                String activityLevel, String goals) {

        super(username, password, email);
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.credits = credits;
        this.allergies = allergies;
        this.sex = sex;
        this.activityLevel = activityLevel;
        this.goals = goals;
    }

    public void addAllergy(Allergy allergy){
        if (this.allergies == null){
            this.allergies = new ArrayList<>();
        }
        this.allergies.add(allergy);
    }

    public void saveMeal(Meal meal){
        if (this.savedMeals == null){
            this.savedMeals = new ArrayList<>();
        }
        this.savedMeals.add(meal);
        meal.setUser(this);
    }


}

