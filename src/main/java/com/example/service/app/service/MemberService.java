package com.example.service.app.service;

import com.example.service.app.dto.crud.AddUserRequest;
import com.example.service.app.dto.crud.AddUserResponse;
import com.example.service.app.dto.member.AddMemberRequest;
import com.example.service.app.dto.member.AddMemberResponse;

public interface MemberService {

    public AddMemberResponse add(AddMemberRequest request);


}
