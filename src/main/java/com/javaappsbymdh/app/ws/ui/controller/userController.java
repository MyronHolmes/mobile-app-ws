package com.javaappsbymdh.app.ws.ui.controller;

import com.javaappsbymdh.app.ws.model.request.UserDetailsRequestModel;
import com.javaappsbymdh.app.ws.model.resonse.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class userController {

    @GetMapping
    public String getUser(){
        return "get user was called";
    }
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        return null;
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}

