package com.codeience.userservice.controller;

import com.codeience.userservice.VO.ResponseTemplateVO;
import com.codeience.userservice.entity.User;
import com.codeience.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User SaveUser(@RequestBody User user)
    {
        log.info("Inside SaveUser method of UserController");
        return userService.SaveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO GetUserWithDepartment( @PathVariable("id") Long userId)
    {
        log.info("Inside GetUserWithDepartment method of UserController");
        return userService.GetUserWithDepartment(userId);
    }
}
