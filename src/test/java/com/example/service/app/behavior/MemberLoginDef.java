package com.example.service.app.behavior;

import com.example.service.app.dto.member.LoginRequest;
import com.example.service.app.entity.member.Account;
import com.example.service.app.repository.AccountRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

public class MemberLoginDef {

    private String account;
    private String password;

    private LoginRequest request = new LoginRequest();

    @MockBean
    private AccountRepository accountRepository;

    @Given("account and password")
    public void accountAndPassword() {
        this.account = "0988018197";
        this.password = "000000";

    }

    @When("a member wants to login the website")
    public void aMemberWantsToLoginTheWebsite() {

    }

    @Then("should fill username and password of form")
    public void shouldFillUsernameAndPasswordOfForm() {

        request.setAccountName(this.account);
        request.setPassword(this.password);
    }

    @And("the member will see a welcome page for member")
    public void theMemberWillSeeAWelcomePageForMember() {

    }

    @And("password should be same as data of database")
    public void passwordShouldBeSameAsDataOfDatabase() {


        Account accountEntity = accountRepository.findByAccount(request.getAccountName());
        Mockito.when(accountRepository.findByAccount(request.getAccountName())).thenReturn(new Account(request.getAccountName(), request.getPassword()));

    }

    @And("the member will login successfully")
    public void theMemberWillLoginSuccessfully() {


    }


}
