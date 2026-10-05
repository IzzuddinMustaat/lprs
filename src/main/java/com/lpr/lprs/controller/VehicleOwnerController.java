package com.lpr.lprs.controller;

import com.lpr.lprs.dto.VehicleOwnerDTO;
import com.lpr.lprs.service.VehicleOwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleOwnerController {

    private final VehicleOwnerService vehicleOwnerService;

    public VehicleOwnerController(VehicleOwnerService vehicleOwnerService) {
        this.vehicleOwnerService = vehicleOwnerService;
    }

    @GetMapping("/vehicle-owner")
    public List<VehicleOwnerDTO> getVehicleOwners() {
        return vehicleOwnerService.getVehicleOwners();
    }
}