package com.codeience.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    @GetMapping("/UserServiceFallBack")
    public String UserServiceFallBackMethod(){
        return "User service is taking longer than usual. Please try again later.";
    }


    @GetMapping("/DepartmentServiceFallBack")
    public String DepartmentServiceFallBackMethod(){
        return "Department service is taking longer than usual. Please try again later.";
    }
}
