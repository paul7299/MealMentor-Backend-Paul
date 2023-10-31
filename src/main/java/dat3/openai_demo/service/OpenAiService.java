package dat3.openai_demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dat3.openai_demo.dtos.ChatCompletionResponse;
import dat3.openai_demo.dtos.ChatCompletionRequest;
import dat3.openai_demo.dtos.MyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@Service
public class OpenAiService {

  @Value("${app.api-key}")
  private String API_KEY;

  public final static String URL = "https://api.openai.com/v1/chat/completions";
  public final static String MODEL = "gpt-3.5-turbo";
  public final static double TEMPERATURE = 0.8;
  public final static int MAX_TOKENS = 300;
  public final static double FREQUENCY_PENALTY = 0.0;
  public final static double PRESENCE_PENALTY = 0.0;
  public final static double TOP_P = 1.0;

  public MyResponse makeRequest(String userPrompt, String _systemMessage) {
    WebClient client = WebClient.create();

    ChatCompletionRequest requestDto = new ChatCompletionRequest();
    requestDto.setModel(MODEL);
    requestDto.setTemperature(TEMPERATURE);
    requestDto.setMax_tokens(MAX_TOKENS);
    requestDto.setTop_p(TOP_P);
    requestDto.setFrequency_penalty(FREQUENCY_PENALTY);
    requestDto.setPresence_penalty(PRESENCE_PENALTY);
    requestDto.getMessages().add(new ChatCompletionRequest.Message("system", _systemMessage));
    requestDto.getMessages().add(new ChatCompletionRequest.Message("user", userPrompt));


    ObjectMapper mapper = new ObjectMapper();
    String json = "";

    try {
      json = mapper.writeValueAsString(requestDto);

      System.out.println(json);
      ChatCompletionResponse response = client.post()
              .uri(new URI(URL))
              .header("Authorization", "Bearer " + API_KEY)
              .contentType(MediaType.APPLICATION_JSON)
              .accept(MediaType.APPLICATION_JSON)
              .body(BodyInserters.fromValue(json))
              .retrieve()
              .bodyToMono(ChatCompletionResponse.class)
              .block();
      //System.out.println(response.toString());
      String responseMsg = response.getChoices().get(0).getMessage().getContent();
      int tokensUsed = response.getUsage().getTotal_tokens();
      System.out.print("Tokens used: " + tokensUsed);
      System.out.print(". Cost ($0.0015 / 1K tokens) : $" + String.format("%6f",(tokensUsed * 0.0015 / 1000)));
      System.out.println(". For 1$, this is the amount of similar requests you can make: " + Math.round(1/(tokensUsed * 0.0015 / 1000)));
      return new MyResponse(responseMsg);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
      String msg = "Internal Server Error, while processing requestDto. You could try again"+
              "( While you develop, make sure to consult the detailed error message on your backend)";
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, msg);

    }
  }
}
