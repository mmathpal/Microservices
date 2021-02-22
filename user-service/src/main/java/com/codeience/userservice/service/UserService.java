package com.codeience.userservice.service;

import com.codeience.userservice.VO.Department;
import com.codeience.userservice.VO.ResponseTemplateVO;
import com.codeience.userservice.entity.User;
import com.codeience.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User SaveUser(User user) {
        log.info("Inside SaveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO GetUserWithDepartment(Long userId) {
        log.info("Inside GetUserWithDepartment method of UserService");

        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
