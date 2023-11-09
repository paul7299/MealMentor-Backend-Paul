package dat3.openai_demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPromptResponse {


    @JsonProperty("age")
    int userAge;
    @JsonProperty("weight")
    int userWeight;
    @JsonProperty("sex")
    String sex;
    @JsonProperty("activityLevel")
    String workoutsPerWeek;
    @JsonProperty("mealChecklist")
    ArrayList<String> mealChecklist;
    @JsonProperty("goals")
    String goals;
    @JsonProperty("preferences")
    ArrayList<String> preferences;


}
