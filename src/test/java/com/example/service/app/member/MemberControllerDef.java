package com.example.service.app.member;

import com.example.service.app.controller.MemberController;
import com.example.service.app.dto.member.LoginForm;
import com.example.service.app.dto.member.RegForm;
import com.example.service.app.entity.shop.Member;
import com.example.service.app.repository.MemberDataRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


@Slf4j
public class MemberControllerDef {


    private String urlPath;
    private URI uri;


    @LocalServerPort
    private int port;
    private String webSiteUrl, loginUrlPath, signupUrlPath,registerFormUrl;

    private String url;
    private RegForm regForm = new RegForm();
    private LoginForm loginForm = new LoginForm();

    private Member member;

    private MemberController memberController = new MemberController();

    @Mock
    private MemberDataRepository memberDataRepository;

    @Before
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }



    @Given("what if everyone visit the website url: {string}, they will be redirect to login-url-path: {string} to show a login-form")
    public void whatIfEveryoneVisitTheWebsiteUrlTheyWillBeRedirectToLoginUrlPathToShowALoginForm(String websiteUrl, String loginUrlPath) {
        //一打開網站，就會被導到登入頁面
        //request website-Url,response login-url-path

        this.webSiteUrl = websiteUrl;
        this.loginUrlPath = loginUrlPath;

    }

    @When("finishing signup-form, I will be redirect to register-form url-path: {string}, the mobile-phone column is already filled my account: {string}")
    public void finishingSignupFormIWillBeRedirectToRegisterFormUrlPathTheMobilePhoneColumnIsAlreadyFilledMyAccount(String registerUrlPath, String mobilePhone) throws IOException, InterruptedException {

        String testUrl = this.url + registerUrlPath + "?mobilePhone=" + mobilePhone;


        ModelAndView expectModelAndView = new ModelAndView("register");
        RegForm regForm = new RegForm();
        regForm.setMemberAccount(mobilePhone);
        expectModelAndView.addObject("regForm", regForm);
        expectModelAndView.setStatus(HttpStatus.OK);

        ModelAndView actualView = memberController.register(mobilePhone);
        this.memberController.register(mobilePhone);

        assertThat(actualView.toString(), equalTo(expectModelAndView.toString()));


    }
    @Then("I have to fill my name: {string}, password: {string}, confirm-password: {string} to finish register-form")
    public void iHaveToFillMyNamePasswordConfirmPasswordToFinishRegisterForm(String memberName, String memberPassword, String memberConfirmPassword) {
        this.regForm.setMemberName(memberName);
        this.regForm.setPassword(memberPassword);
        this.regForm.setConfirmPassword(memberConfirmPassword);


    }

//        this.regForm.setMemberName(name);
//        this.regForm.setMemberPassword(password);
//        Assert.assertNotNull("name不可為0",this.regForm.getMemberName());
//        Assert.assertEquals(this.regForm.getMemberPassword(),confirmPassword);





    @And("after I submit register-form, my account is be created by system, signup is successfully")
    public void afterISubmitRegisterFormMyAccountIsBeCreatedBySystemSignupIsSuccessfully() {
    }

    @When("{string} visit website,he has to fill his account: {string}, and his password: {string} on login-from")
    public void visitWebsiteHeHasToFillHisAccountAndHisPasswordOnLoginFrom(String memberName, String memberPassword, String memberConfirmPassword) {


    }

    @Then("after submitting login-form to url-path: {string}, system will verify his password by database")
    public void afterSubmittingLoginFormToUrlPathSystemWillVerifyHisPasswordByDatabase(String loginUrlPath) {
    }

    @And("he will be redirected to welcome url-path: {string}, and see welcome message: {string}")
    public void heWillBeRedirectedToWelcomeUrlPathAndSeeWelcomeMessage(String welcomeUrlPath, String welcomeMessage) {
    }

    @Given("a member: {string}, account: {string} who has already login")
    public void aMemberAccountWhoHasAlreadyLogin(String memberName, String memberAccount) {
    }

    @When("member use member-menu to visit change-password-url-path: {string} to show change-password-form")
    public void memberUseMemberMenuToVisitChangePasswordUrlPathToShowChangePasswordForm(String changePasswordUrlPath) {
    }

    @Then("he has to fill {string} to old-password column, new-password: {string}, confirm-new-password: {string} on the form")
    public void heHasToFillToOldPasswordColumnNewPasswordConfirmNewPasswordOnTheForm(String oldPassword, String newPassword, String confirmNewPassword) {
    }

    @And("account old-password must be verified by database")
    public void accountOldPasswordMustBeVerifiedByDatabase() {
    }

    @And("account new-password will be override into database")
    public void accountNewPasswordWillBeOverrideIntoDatabase() {
    }

    @And("member will be redirect to account url-path: {string} to show message {string}")
    public void memberWillBeRedirectToAccountUrlPathToShowMessage(String accountUrlPath, String message) {
    }
}
