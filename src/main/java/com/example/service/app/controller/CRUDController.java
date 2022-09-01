package com.example.service.app.controller;

import com.example.service.app.dto.crud.*;
import com.example.service.app.service.impl.CRUDUserServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api("CRUD Controller")
@Validated
@Slf4j
@RestController
public class CRUDController {

    @Autowired
    private CRUDUserServiceImpl userService;


    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public AddUserResponse getAddResponse(@Valid @RequestBody AddUserRequest request) throws Exception {

        return userService.add(request);
    }

    @PostMapping(value = "/del", produces = MediaType.APPLICATION_JSON_VALUE)
    public DelUserResponse getDelResponse(@Valid @RequestBody DelUserRequest request) throws Exception {

        return userService.del(request);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateUserResponse getUpdateResponse(@Valid @RequestBody UpdateUserRequest request) throws Exception {

        return userService.update(request);
    }

    @PostMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public QueryUserResponse getQueryResponse(@Valid @RequestBody QueryUserRequest request) throws Exception {
        return userService.query(request);
    }
}
