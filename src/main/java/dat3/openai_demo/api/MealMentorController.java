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
          "and approximate calorie count for the meal. "
                  +
                  "Ingredients should be presented as a simple string, for example 3 eggs or 2 tbsp salt or 200g flour"
                  +
                  "In the \"Description\" section, provide a short explanation for the nutritional value of the dish, " +
                  "and why this specific meal have been picked for the user, " +
                  "in relation the user's weight, activity level, preferences, allergies and the users goals."
                  +
                  "Be sure to mention that the dish do not contain what the user is allergic to."
                  +
                  "mealType is breakfast, lunch or dinner"
                  +

                  "\n" +
                  "{\n" +
                  "    \"mealType\": {\n" +
                  "      \"mealTitle\": \"Name of the Meal\",\n" +
                  "      \"Ingredients\": {\n" +
                  "        \"Amount of Ingredient1 and Ingredient1\",\n" +
                  "        \"Amount of Ingredient2 and Ingredient2\",\n" +
                  "        ...\n" +
                  "      },\n" +
                  "      \"Calories\": \"Calorie count\"\n" +
                  "      \"Protein\": \"Protein count\"\n" +
                  "      \"Carbohydrates\": \"Carbohydrate count\"\n" +
                  "      \"Fat\": \"Fat count\"\n" +
                  "      \"Description\": \"Description\"\n" +
                  "      \"Instructions\": \"Instruction on how to prepare the meal\"\n" +
                  "    },\n" +
                  "    ...\n" +
                  "  },\n" +
                  "  ...\n" +
                  "\n" +
          "Each ingredient's quantity should be listed in metric units or amount." +
          "Include meals for Breakfast, Lunch, and/or Dinner, depending on the user input. " +
                  "If the user's request lacks details for meal plan creation, " +
                  "the API should respond with a JSON object asking for the necessary information. " +
                  "The API's responses should consistently follow this format " +
                  "and should contain only the JSON-formatted meal plan, not any regular text, and no followup questions.\n" +
                  "The response should only contain meals for 1 day\n";

  public MealMentorController(OpenAiService service) {
    this.service = service;
  }


  @PostMapping()
      public MyResponse generatePrompt(@RequestBody UserPromptResponse userPromptResponse){


      String userPrompt = "I am a " + userPromptResponse.getUserAge() + " old "
              + userPromptResponse.getSex() +
              "and " + "i workout" + userPromptResponse.getWorkoutsPerWeek() + "times a week " +
              "The recipes should include" + userPromptResponse.getMealChecklist() + "and must not include " + userPromptResponse.getPreferences()
              + ". My goals are" + userPromptResponse.getGoals()

               + " i want the recipe made for " /* + userPromptResponse.getAmountOfDays() + "number of days" */ ;

      return service.makeRequest(userPrompt, SYSTEM_MESSAGE);

  }

}
