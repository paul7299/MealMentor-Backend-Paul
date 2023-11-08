package dat3.openai_demo.dtos;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPromptResponse {

    int userAge;
    int userWeight;
    String sex;
    String workoutsPerWeek;
    ArrayList<String> mealChecklist;
    String goals;
    ArrayList<String> preferences;


}
