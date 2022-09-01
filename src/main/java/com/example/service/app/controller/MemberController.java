package com.example.service.app.controller;

import com.example.service.app.dto.member.AddMemberRequest;
import com.example.service.app.dto.member.AddMemberResponse;
import com.example.service.app.dto.member.RegForm;
import org.hibernate.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RestController
public class MemberController {

    @GetMapping("/")
    public ModelAndView visitor() {

        return new ModelAndView("redirect:" + "/login");
    }


//    @GetMapping("/register")
//    public ModelAndView register(@RequestParam(required = false) String mobilePhone) {
//        RegForm regForm = new RegForm();
//        regForm.setMemberAccount(mobilePhone);
//        ModelAndView modelAndView = new ModelAndView("register");
//        modelAndView.addObject("regForm", regForm);
//        modelAndView.setStatus(HttpStatus.OK);
//        return modelAndView;
//    }


    @GetMapping("/register")
    public ModelAndView register(@RequestParam(required = false) String mobilePhone) {
        RegForm regForm = new RegForm();
        regForm.setMemberAccount(mobilePhone);

        AddMemberRequest addMemberRequest = new AddMemberRequest();
        addMemberRequest.setRegForm(regForm);
        addMemberRequest.getRegForm().setMemberAccount(mobilePhone);


        //跳轉至註冊頁面，手機號碼自動帶入account
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("AddMemberRequest", addMemberRequest.getRegForm());
        modelAndView.setStatus(HttpStatus.OK);
        return modelAndView;
    }


    @PostMapping("/register")
    public ModelAndView getNewMember(@ModelAttribute AddMemberRequest addMemberRequest) {
        AddMemberResponse addMemberResponse = new AddMemberResponse();
        //將輸入好的註冊資料存進資料庫，並跳轉至註冊成功頁面
        ModelAndView modelAndView = new ModelAndView("registerSuccess");
        modelAndView.addObject("addMemberResponse", addMemberResponse);
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login() {

        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }


    @GetMapping("/welcome")
    public ModelAndView welcome(HttpServletRequest request) {
        //String name = (String) request.getAttribute("name");
        ModelAndView modelAndView = new ModelAndView("Welcome");
        modelAndView.getModel().put("name", "Tom");
        return modelAndView;
    }





}
