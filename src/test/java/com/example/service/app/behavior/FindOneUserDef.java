package com.example.service.app.behavior;

import com.example.service.app.dto.crud.QueryUserRequest;
import com.example.service.app.dto.crud.QueryUserResponse;
import com.example.service.app.entity.crud.User;
import com.example.service.app.repository.UserRepository;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindOneUserDef implements En {

    Optional<User> userOptional;

    private User user = new User(1000L, "Peter", "0999123456");
    @Autowired
    UserRepository userRepository;

    public FindOneUserDef() {
        When("^send user to query method$", () -> {
            userRepository.save(user);
            assertThat(1000L, equalTo(user.getId()));
        });
        Then("^show a user of the id$", () -> {
            this.userOptional = userRepository.findById(user.getId());
            assertThat(user.getId(), equalTo(userOptional.get().getId()));
        });
        But("^user should be exist$", () -> {
            assertTrue(this.userOptional.isPresent());
            userRepository.deleteById(user.getId());
        });
    }

}
