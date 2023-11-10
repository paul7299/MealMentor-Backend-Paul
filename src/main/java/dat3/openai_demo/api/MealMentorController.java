package dat3.openai_demo.api;

import dat3.openai_demo.dtos.MyResponse;
import dat3.openai_demo.dtos.UserPromptResponse;
import dat3.openai_demo.service.OpenAiService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mealPlanGenerator")
@CrossOrigin(origins = "*")
public class MealMentorController {

  private OpenAiService service;
  final static String SYSTEM_MESSAGE =
          "You are an AI assistant whose sole function is to generate structured meal plans tailored to users' dietary requirements. " +
                  "When prompted, you will produce a JSON object detailing a meal plan that includes meal titles, ingredients with quantities, " +
                  "and approximate calorie count for the meal. The JSON object must follow this structure for each day of the week:\n" +
                  "\n" +
                  "{\n" +
                  "  \"Day\": {\n" +
                  "    \"MealType\": {\n" +
                  "      \"Meal\": \"Name of the Meal\",\n" +
                  "      \"Ingredients\": {\n" +
                  "        \"Ingredient1\": \"Quantity\",\n" +
                  "        \"Ingredient2\": \"Quantity\",\n" +
                  "        ...\n" +
                  "      },\n" +
                  "      \"Calories\": \"Calorie count\"\n" +
                  "    },\n" +
                  "    ...\n" +
                  "  },\n" +
                  "  ...\n" +
                  "}\n" +
                  "\n" +
                  "Each ingredient's quantity should be listed in metric units, and the units should be included in the same JSON object as the quantity. " +
                  "Include meals for Breakfast, Lunch, and Dinner, depending on the user input. If the user's request lacks details for meal plan creation, " +
                  "the API should respond with a JSON object asking for the necessary information. The API's responses should consistently follow this format " +
                  "and should contain only the JSON-formatted meal plan, not any regular text, and no followup questions.\n";

  public MealMentorController(OpenAiService service) {
    this.service = service;
  }



  @PostMapping()
      public MyResponse generatePrompt(@RequestBody UserPromptResponse userPromptResponse){


      String userPrompt = "I am a " + userPromptResponse.getUserAge() + " old "
              + userPromptResponse.getSex() +
              "and " + "i workout" + userPromptResponse.getWorkoutsPerWeek() + "times a week " +
              "The recipes should include" + userPromptResponse.getMealChecklist() + "and must not include " + userPromptResponse.getPreferences()
              + ". My goals are" + userPromptResponse.getGoals() + " i want the recipe made for " + userPromptResponse.getAmountOfDays() + "number of days";

      return service.makeRequest(userPrompt, SYSTEM_MESSAGE);

  }

}
