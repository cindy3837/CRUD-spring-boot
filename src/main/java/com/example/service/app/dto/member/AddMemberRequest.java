package com.example.service.app.dto.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.ModelAndView;

@Data
@NoArgsConstructor
public class AddMemberRequest {


    private RegForm regForm;


    public AddMemberRequest(RegForm regForm) {
        this.regForm = regForm;
    }



}
