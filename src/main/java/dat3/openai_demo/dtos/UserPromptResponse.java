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
    @JsonProperty("activity-level")
    String workoutsPerWeek;
    @JsonProperty("mealChecklistDiv")
    ArrayList<String> mealChecklist;
    @JsonProperty("goals")
    String goals;
    @JsonProperty("preference-input")
    ArrayList<String> preferences;


}
