package com.example.demo.controller;


import com.example.demo.model.AppUser;
import com.example.demo.model.AppUserRepository;
import com.example.demo.model.UserRole;
import com.example.demo.model.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.PostConstruct;

@Controller
public class MainController {

    @Autowired
    UserRoleRepository roles;

    @Autowired
    AppUserRepository users;

    @RequestMapping("/") public String home(){
        return "index";
    }

    @PostConstruct
    public void loadData()
    {
        UserRole ordinaryStudent = new UserRole("STUDENT");
        roles.save(ordinaryStudent);

        UserRole teacher = new UserRole("TEACHER");
        roles.save(teacher);

        AppUser newStudent = new AppUser("student","password");
        newStudent.addRole(ordinaryStudent);
        users.save(newStudent);

        AppUser newTeacher = new AppUser("teacher","password");
        newTeacher.addRole(teacher);
        users.save(newTeacher);
    }
}
