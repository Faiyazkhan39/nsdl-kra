package com.nsdl.kra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsdl.kra.helpers.BaseResponse;
import com.nsdl.kra.helpers.Constants;
import com.nsdl.kra.model.dto.UserResponse;
import com.nsdl.kra.model.dto.UsersRequest;
import com.nsdl.kra.services.UserService;

@RestController
@RequestMapping("/user")
public class UsersControllers {

    @Autowired
    private UserService userService;

    @GetMapping()
    public BaseResponse<UserResponse> getUserId(@RequestBody UsersRequest usersRequest) throws Exception {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserDetails(userService.getUserDetails(usersRequest));
        return new BaseResponse<>(userResponse, BaseResponse.ResponseStatus.SUCCESS, HttpStatus.OK.value(),
                Constants.USER_FOUND);
    }
}
