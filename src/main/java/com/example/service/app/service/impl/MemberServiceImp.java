package com.example.service.app.service.impl;


import com.example.service.app.dto.member.AddMemberRequest;
import com.example.service.app.dto.member.AddMemberResponse;
import com.example.service.app.entity.member.Member;

import com.example.service.app.repository.MemberRepository;
import com.example.service.app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public AddMemberResponse add(AddMemberRequest request) {

        AddMemberResponse response = new AddMemberResponse();
        Member member = new Member();
        member.setMemberAccount(request.getRegForm().getMemberAccount());
        member.setMemberName(request.getRegForm().getMemberName());
        member.setPassword(request.getRegForm().getPassword());
        member.setConfirmPassword(request.getRegForm().getConfirmPassword());

        memberRepository.save(member);
        response.setStatus("註冊成功");

        return response;
    }
}
