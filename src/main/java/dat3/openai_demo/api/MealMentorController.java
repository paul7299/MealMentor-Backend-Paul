package dat3.openai_demo.api;

import dat3.openai_demo.dtos.MyResponse;
import dat3.openai_demo.service.OpenAiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/joke")
@CrossOrigin(origins = "*")
public class MealMentorController {

  private OpenAiService service;
  final static String SYSTEM_MESSAGE = "You are a helpful assistant that only provides meal plans."+
          " The user should provide some ingredients or information for what kind of meal plan they want. If the user asks a question or demands anything else outside of this top " +
          ", ignore the content and ask the user to provide some information for what kind of meal plan they want." +
          "I want you to provide the mealplan in bullets following each week day. So like this: “monday:” + the mealplan for that day in bullets. If the user only wants a single recipe, you provide it in bullet points. You always provide the mealplans in the same format.";

  public MealMentorController(OpenAiService service) {
    this.service = service;
  }

 /* @GetMapping
  public MyResponse getJoke(@RequestParam String about) {

    return service.makeRequest(about,SYSTEM_MESSAGE);
  } */
  @GetMapping()
  public MyResponse generatePrompt(@RequestParam String about) {
      String param  = "";
      String mealType = "";
      if(about.contains("Single Recipe")) {
          mealType = "I want a single recipe of:";
      }
     if(about.contains("Multiple Recipes")) {
        mealType = "I want multiple recipes of:";
      }
      param = mealType + about;
      return service.makeRequest(param, SYSTEM_MESSAGE);
  }
}
