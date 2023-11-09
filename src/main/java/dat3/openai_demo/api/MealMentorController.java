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
  final static String SYSTEM_MESSAGE = "You are a helpful assistant that only provides meal plans."+
          " The user should provide some ingredients or information for what kind of meal plan they want. " +
          "If the user asks a question or demands anything else outside of this top " +
          ", ignore the content and ask the user to provide some information for what kind of meal plan they want." +
          "I want you to provide the mealplan in bullets following each week day. " +
          "So like this: “monday:” + the mealplan for that day in bullets. If the user only wants a single recipe, " +
          "you provide it in bullet points. You always provide the mealplans in the same format.";

  public MealMentorController(OpenAiService service) {
    this.service = service;
  }



  @GetMapping()
      public MyResponse generatePrompt(@RequestBody UserPromptResponse userPromptResponse){


      String userPrompt = "I am a " + userPromptResponse.getUserAge() + " old "
              + userPromptResponse.getSex() +
              "and  " ;

      return service.makeRequest(userPrompt, SYSTEM_MESSAGE);

  }

}
