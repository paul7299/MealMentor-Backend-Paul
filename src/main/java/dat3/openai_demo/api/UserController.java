package dat3.openai_demo.api;

import dat3.openai_demo.dtos.UserRequest;
import dat3.openai_demo.entity.User;
import dat3.openai_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam String username){
        User user = userRepository.findByUsername(username);
        if (user != null)
            return ResponseEntity.ok(user);
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("{username}")
    public ResponseEntity<String> updateUserSettings(@PathVariable String username, @RequestBody UserRequest userRequest){
        User userEdit = userRepository.findByUsername(username);

        if (userEdit != null){
            userEdit.setWeight(userRequest.getWeight());
            userEdit.setHeight(userRequest.getHeight());
            userEdit.setAge(userRequest.getAge());
            userEdit.setAllergies(userRequest.getAllergies());
            userEdit.setActivityLevel(userRequest.getActivityLevel());

            userRepository.save(userEdit);
            return ResponseEntity.ok("User updated");
        }
        else return ResponseEntity.notFound().build();
    }
}
