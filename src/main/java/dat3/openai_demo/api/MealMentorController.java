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
          ", ignore the content and ask the user to provide some information for what kind of meal plan they want.";

  public MealMentorController(OpenAiService service) {
    this.service = service;
  }

  @GetMapping
  public MyResponse getJoke(@RequestParam String about) {

    return service.makeRequest(about,SYSTEM_MESSAGE);
  }
}
