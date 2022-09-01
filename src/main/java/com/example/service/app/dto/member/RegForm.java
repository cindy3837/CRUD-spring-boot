package com.example.service.app.dto.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.ModelAndView;

@Data
@NoArgsConstructor
public class RegForm {

    private String memberAccount;

    private String memberName;

    private String memberSMSCode;

    private String password;

    private String confirmPassword;

    public RegForm(String memberPhone) {
        this.memberAccount = memberPhone;
    }

    public ModelAndView getRegisterForm(String memberPhone) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("memberPhone", this.memberAccount);
        return modelAndView;
    }



}
