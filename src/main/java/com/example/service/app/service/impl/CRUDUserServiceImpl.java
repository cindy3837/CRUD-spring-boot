package com.example.service.app.service.impl;

import com.example.service.app.dto.crud.*;
import com.example.service.app.entity.crud.User;
import com.example.service.app.exception.UserException;
import com.example.service.app.repository.UserRepository;
import com.example.service.app.service.CRUDUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CRUDUserServiceImpl implements CRUDUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AddUserResponse add(AddUserRequest request) {
        User user = new User();
        AddUserResponse response = new AddUserResponse();

        if(StringUtils.isBlank(request.getUsername())){
            response.setStatus("Failed");
            return response;
        }

        if(StringUtils.isBlank(request.getPhone())){
            response.setStatus("Failed");
            return response;
        }

        user.setUsername(request.getUsername());
        user.setPhone(request.getPhone());
        userRepository.save(user);

        response.setStatus("Success");
        return response;
    }

    @Override
    public DelUserResponse del(DelUserRequest request) {

        Optional<User> userOptional = userRepository.findById(Long.valueOf(request.getId()));
        DelUserResponse response = new DelUserResponse();
        if (!userOptional.isEmpty()) {
            userRepository.deleteById(Long.valueOf(request.getId()));
            response.setStatus("del Success");
        } else {
            response.setStatus("del failed");
        }

        return response;
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {

        Optional<User> userOptional = userRepository.findById(Long.valueOf(request.getId()));
        UpdateUserResponse response = new UpdateUserResponse();
        if (!userOptional.isEmpty()) {
            User user = userOptional.get();
            user.setPhone(request.getPhone());
            user.setUsername(request.getUsername());
            userRepository.save(user);
            response.setStatus("Update Success");
        } else {
            response.setStatus("Update failed");
        }
        return response;
    }

    @Override
    public QueryUserResponse query(QueryUserRequest request) {

        List<User> userList = new ArrayList<>();
        QueryUserResponse response = new QueryUserResponse();

        Optional<User> userOptional = userRepository.findById(Long.valueOf(request.getId()));

        if (!userOptional.isEmpty()) {
            User user = userOptional.get();
            userList.add(user);
            response.setUserList(userList);

        } else {

            throw new UserException("user not found");
        }
        return response;
    }
}
