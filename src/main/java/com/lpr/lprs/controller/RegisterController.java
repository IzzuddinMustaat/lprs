package com.lpr.lprs.controller;

import com.lpr.lprs.dto.RegistrationDTO;
import com.lpr.lprs.service.RegisterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegisterController {

    private final RegisterService registerService;

    // Constructor injection
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationDTO dto) {
        registerService.register(dto);
        return "Data saved successfully!";
    }
}