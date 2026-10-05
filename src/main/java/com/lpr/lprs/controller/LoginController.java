package com.lpr.lprs.controller;

import com.lpr.lprs.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginController {

    private final LoginService loginService;

    // Constructor Injection
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {

        boolean result = loginService.login(username, password);

        return result ? "success" : "failure"; // return "success" or "failure" based on login result
    }
}