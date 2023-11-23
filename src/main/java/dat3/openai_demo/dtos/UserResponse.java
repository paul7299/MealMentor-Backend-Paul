package dat3.openai_demo.dtos;

import dat3.openai_demo.entity.Allergy;
import dat3.openai_demo.entity.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    String username;
    int weight;
    int height;
    int age;
    List<Allergy> allergies;
    String sex;
    String activityLevel;
    String goals;

    public UserResponse(User user) {
        this.username = user.getUsername();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.age = user.getAge();
        this.allergies = user.getAllergies();
        this.sex = user.getSex();
        this.activityLevel = user.getActivityLevel();
        this.goals = user.getGoals();
    }
}
