package com.lpr.lprs.controller;

import com.lpr.lprs.service.VehicleLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VehicleLogController {

    private final VehicleLogService vehicleLogService;

    public VehicleLogController(VehicleLogService vehicleLogService) {
        this.vehicleLogService = vehicleLogService;
    }

    @GetMapping("/vehicle-log")
    public List<Map<String, Object>> getLogs() {
        return vehicleLogService.getLogs();
    }
}