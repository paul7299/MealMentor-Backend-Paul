package dat3.openai_demo.api;

import dat3.openai_demo.dtos.MyResponse;
import dat3.openai_demo.dtos.UserPromptResponse;
import dat3.openai_demo.dtos.UserResponse;
import dat3.openai_demo.entity.User;
import dat3.openai_demo.service.OpenAiService;
import dat3.openai_demo.service.UserService;
import dat3.security.service.UserDetailsServiceImp;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/mealPlanGenerator")
@CrossOrigin
public class MealMentorController {

  private OpenAiService openAiService;
  private UserService userService;
  String SYSTEM_MESSAGE = getSystemMessage();

  public MealMentorController(OpenAiService openAiService, UserService userService) {
    this.openAiService = openAiService;
    this.userService = userService;
  }



    @PostMapping()
      public MyResponse generatePrompt(@RequestBody UserPromptResponse userPromptResponse){

      if (userPromptResponse.getGoals().equalsIgnoreCase("errortest")){
          throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                  "** ERROR TEST **");
      }
            // Check if the user has credits
        if (userService.getUser(userPromptResponse.getUsername()).getCredits() <= 0) {

            return new MyResponse("{\n" +
                    "    \"Message\": \"USER HAS NO CREDITS\"\n" +
                    "}");

        } else {

            // Removing one credit from the user's credits
            String usernamePrompting = userPromptResponse.getUsername();
            UserResponse user = userService.getUser(usernamePrompting);
            userService.removeOneCreditFromUser(usernamePrompting);

            // Printing how many cr
            System.out.println("****** " + user.getUsername() + " is PROMPTING *******\n" +
                    "****** and he/she has got " +
                    userService.getUser(usernamePrompting).getCredits()
                    + " credits left *****");

      String userPrompt = "I am a " + user.getAge() + " old "
              + user.getSex() +
              "and " + "i workout" + user.getActivityLevel() + "times a week " +
              "The recipes should include" + userPromptResponse.getMealChecklist() + "and must not include " + user.getAllergies()
              + ". My goals are" + user.getGoals()

                    + " i want the recipe made for " /* + userPromptResponse.getAmountOfDays() + "number of days" */ ;

            return openAiService.makeRequest(userPrompt, SYSTEM_MESSAGE);
        }



  }

  private String getSystemMessage() {

      final String string =
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
              "......"
              +
              "{"
              + "\"Day 1\": ["
              + "  {"
              + "    \"Type of Meal\": \"Breakfast\","
              + "    \"Title\": \"Protein-Packed Omelette\","
              + "    \"Ingredients\": ["
              + "      \"3 eggs\","
              + "      \"100g lean turkey breast, diced\","
              + "      \"50g spinach\","
              + "      \"30g low-fat cheese, grated\","
              + "      \"1/2 red bell pepper, diced\","
              + "      \"1/4 onion, diced\","
              + "      \"Salt and pepper to taste\""
              + "    ],"
              + "    \"Calories\": \"450kcal\","
              + "    \"Protein\": \"40g\","
              + "    \"Carbohydrates\": \"10g\","
              + "    \"Fat\": \"25g\","
              + "    \"Time to make\": \"30 min\","
              + "    \"Description\": \"This omelette is packed with protein from the eggs and lean turkey breast. It also contains spinach, which is rich in vitamins and minerals. The low-fat cheese adds a creamy texture without adding excessive calories. This meal is great for weight loss as it provides a satisfying amount of protein to support muscle growth and repair while keeping the calorie count moderate.\","
              + "    \"Instructions\": \"1. In a bowl, whisk the eggs with salt and pepper. 2. Heat a non-stick pan over medium heat and add the diced turkey breast, onion, and bell pepper. Cook until the turkey is browned and the vegetables are softened. 3. Add the spinach to the pan and cook until wilted. 4. Pour the whisked eggs over the turkey and vegetables. Cook until the eggs are set. 5. Sprinkle the grated low-fat cheese over the omelette. 6. Carefully fold the omelette in half and cook for another minute to melt the cheese. 7. Serve hot.\""
              + "  }"
              + "]"
              + "}"
              +

              "Each ingredient's quantity should be listed in metric units or amount." +
              "Include meals for Breakfast, Lunch, and/or Dinner, depending on the user input. " +
              "If the user's request lacks details for meal plan creation, " +
              "the API should respond with a JSON object asking for the necessary information. " +
              "The API's responses should consistently follow this format " +
              "and should contain only the JSON-formatted meal plan, not any regular text, and no followup questions.\n" +
              "The response should only contain meals for 1 day\n";

      return string;
  }


}
