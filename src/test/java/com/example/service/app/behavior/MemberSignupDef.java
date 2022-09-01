package com.example.service.app.behavior;

import com.example.service.app.dto.member.SignupFormRequest;
import com.example.service.app.entity.member.Account;
import com.example.service.app.repository.AccountRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

public class MemberSignupDef {

    private SignupFormRequest signupFormRequest = new SignupFormRequest();

    @MockBean
    private AccountRepository accountRepository;


}


