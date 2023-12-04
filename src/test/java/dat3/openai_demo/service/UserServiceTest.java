package dat3.openai_demo.service;

import dat3.openai_demo.TestUtils;
import dat3.openai_demo.repository.AllergyRepository;
import dat3.openai_demo.repository.UserRepository;
import dat3.openai_demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserServiceTest {
    @Autowired
    UserService userService;
    UserRepository userRepository;
    AllergyRepository allergyRepository;

    private boolean dataInitialized = false;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, allergyRepository);
        if(!dataInitialized) {
            userRepository.deleteAll();
            TestUtils.setupTestUsers(userRepository);
            dataInitialized = true;
        }
    }

    @Test
    void getUser() {

    }

    @Test
    void updateUser(){

    }
}
