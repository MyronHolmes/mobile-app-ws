package com.javaappsbymdh.app.ws.ui.controller;

import com.javaappsbymdh.app.ws.model.request.UserDetailsRequestModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class userController {

    @GetMapping
    public String getUser(){
        return "get user was called";
    }
    @PostMapping
    public String createUser(@RequestBody UserDetailsRequestModel userDetails){
        return "create user was called";
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

