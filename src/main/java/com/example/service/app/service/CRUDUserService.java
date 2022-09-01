package com.example.service.app.service;

import com.example.service.app.dto.crud.*;

public interface CRUDUserService {

    public AddUserResponse add(AddUserRequest request);

    public DelUserResponse del(DelUserRequest request);

    public UpdateUserResponse update(UpdateUserRequest request);

    public QueryUserResponse query(QueryUserRequest request);
}
