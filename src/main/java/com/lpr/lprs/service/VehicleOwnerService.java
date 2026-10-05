package com.lpr.lprs.service;

import com.lpr.lprs.dto.VehicleOwnerDTO;
import com.lpr.lprs.repository.VehicleOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleOwnerService {

    private final VehicleOwnerRepository vehicleOwnerRepo;

    public VehicleOwnerService(VehicleOwnerRepository vehicleOwnerRepo) {
        this.vehicleOwnerRepo = vehicleOwnerRepo;
    }

    public List<VehicleOwnerDTO> getVehicleOwners() {
        return vehicleOwnerRepo.getVehicleOwnerData();
    }
}