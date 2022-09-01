package com.example.service.app.controller;

import com.example.service.app.dto.crud.*;
import com.example.service.app.entity.crud.User;
import com.example.service.app.repository.UserRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class CRUDControllerDef {


    @LocalServerPort
    private int port;

    String SERVER_URL = "http://localhost";
    String ADD = "/add";
    String DEL = "/del";
    String UPDATE = "/update";
    String QUERY = "/query";

    RestTemplate restTemplate = new RestTemplate();

    @Autowired //TODO 改為 Mockito
    UserRepository userRepository;

    AddUserResponse addUserResponse;
    AddUserRequest addUserRequest = new AddUserRequest();
    QueryUserRequest queryUserRequest = new QueryUserRequest();
    UpdateUserRequest updateUserRequest = new UpdateUserRequest();
    DelUserRequest delUserRequest = new DelUserRequest();

    @When("given a url that means add action")
    public void givenAUrlThatMeansAddAction() {

        this.addUserRequest.setId(999L);
        this.addUserRequest.setUsername("Peter");
        this.addUserRequest.setPhone("0912345678");
        assertThat(ADD, equalTo("/add"));
        log.info("TEST URL = /add = {}", ADD);

    }

    @Then("read all attributes from addUserRequest")
    public void readAllAttributesFromAddUserRequest() {
        assertThat(addUserRequest.getUsername(), equalTo("Peter"));
        assertThat(addUserRequest.getPhone(), equalTo("0912345678"));
    }

    @And("save user to table")
    public void saveUserToTable() {
        User user = new User();
        shouldNotBeBlankOrNull(addUserRequest.getId(), addUserRequest.getUsername(), addUserRequest.getPhone());
        user.setId(addUserRequest.getId());
        user.setUsername(addUserRequest.getUsername());
        user.setPhone(addUserRequest.getPhone());
        userRepository.save(user);
        //Mockito.when(userRepository.findById(999L)).thenReturn(Optional.of(new User(999L, "Peter", "0988018197")));
        // 定義當調用mock userDao的getUserById()方法，並且參數為3時，就返回id為200、name為I'm mock3的user對象
        // Mockito.when(userDao.getUserById(3)).thenReturn(new User(200, "I'm mock 3"));
        Optional<User> userEntity = userRepository.findById(addUserRequest.getId());
        assertTrue(userEntity.isPresent());
    }


    @When("given a url that means query action")
    public void givenAUrlThatMeansQueryAction() {

        this.queryUserRequest.setId(999L);
        assertThat(QUERY, equalTo("/query"));
        log.info("TEST URL = /query = {}", QUERY);

    }

    @Then("read all attributes from queryUserRequest")
    public void readAllAttributesFromQueryUserRequest() {
        assertThat(queryUserRequest.getId(), lessThanOrEqualTo(999L));
    }

    @And("query user from table")
    public void queryUserFromTable() {
        Optional<User> userOptional = userRepository.findById(queryUserRequest.getId());
        assertTrue(userOptional.isPresent());
    }


    @When("given a url that means update action")
    public void givenAUrlThatMeansUpdateAction() {
        this.updateUserRequest.setId(999L);
        this.updateUserRequest.setUsername("Master");
        this.updateUserRequest.setPhone("0000000000");

        assertThat(UPDATE, equalTo("/update"));
        log.info("TEST URL = /update = {}", UPDATE);
    }

    @Then("read all attributes from updateUserRequest")
    public void readAllAttributesFromUpdateUserRequest() {
        assertThat(updateUserRequest.getUsername(), equalTo("Master"));
        assertThat(updateUserRequest.getPhone(), equalTo("0000000000"));
    }

    @And("update user to table")
    public void updateUserToTable() throws Exception {

        shouldNotBeBlankOrNull(updateUserRequest.getId(), updateUserRequest.getUsername(), updateUserRequest.getPhone());


        Optional<User> userOptional = userRepository.findById(updateUserRequest.getId());
        assertTrue(userOptional.isPresent());
        User user = userOptional.get();

        User oldUser = new User();
        oldUser.setId(user.getId());
        oldUser.setUsername(user.getUsername());
        oldUser.setPhone(user.getPhone());

        user.setId(updateUserRequest.getId());
        user.setUsername(updateUserRequest.getUsername());
        user.setPhone(updateUserRequest.getPhone());

        userRepository.save(user);

        assertThat(user.getUsername(), not(oldUser.getUsername()));
        assertThat(user.getPhone(), not(oldUser.getPhone()));

    }

    @When("given a url that means delete action")
    public void givenAUrlThatMeansDeleteAction() {

        this.delUserRequest.setId(999L);
        assertThat(DEL, equalTo("/del"));
    }

    @Then("read all attributes from deleteUserRequest")
    public void readAllAttributesFromDeleteUserRequest() {
        idShouldBe(delUserRequest.getId());
    }

    @And("delete user from table")
    public void deleteUserFromTable() {
        Optional<User> findUserOptional = userRepository.findById(delUserRequest.getId());
        assertTrue(findUserOptional.isPresent());
        userRepository.deleteById(delUserRequest.getId());
        Optional<User> ensureUserOptional = userRepository.findById(delUserRequest.getId());
        assertTrue(ensureUserOptional.isEmpty());

    }

    @But("id should be {long}")
    public void idShouldBe(long id) {
        assertThat(id, equalTo(999L));
    }

    @But("id should be {long},{string},{string} should not be blank or null")
    public void shouldNotBeBlankOrNull(Long id, String username, String phone) {
        assertTrue(StringUtils.isNotBlank(username));
        assertTrue(StringUtils.isNotBlank(phone));
        assertThat(id, equalTo(999L));
    }


}
