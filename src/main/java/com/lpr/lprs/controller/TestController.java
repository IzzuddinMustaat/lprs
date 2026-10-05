package com.lpr.lprs.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "LPR System is working!";
    }
}
