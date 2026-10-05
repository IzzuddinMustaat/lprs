package com.lpr.lprs.service;

import com.lpr.lprs.dto.RegistrationDTO;
import com.lpr.lprs.model.Owner;
import com.lpr.lprs.model.Vehicle;
import com.lpr.lprs.model.VehicleOwner;
import com.lpr.lprs.repository.OwnerRepository;
import com.lpr.lprs.repository.VehicleRepository;
import com.lpr.lprs.repository.VehicleOwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final OwnerRepository ownerRepo;
    private final VehicleRepository vehicleRepo;
    private final VehicleOwnerRepository vehicleOwnerRepo;

    // Constructor injection
    public RegisterService(OwnerRepository ownerRepo,
                           VehicleRepository vehicleRepo,
                           VehicleOwnerRepository vehicleOwnerRepo) {
        this.ownerRepo = ownerRepo;
        this.vehicleRepo = vehicleRepo;
        this.vehicleOwnerRepo = vehicleOwnerRepo;
    }

    public void register(RegistrationDTO dto) {

        // 1. Save Owner
        Owner owner = new Owner();
        owner.setOwnerId(dto.getOwnerId());
        owner.setName(dto.getName());
        owner.setType(dto.getType());
        ownerRepo.save(owner);

        // 2. Save Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setPlateNum(dto.getPlateNum());
        vehicle.setColour(dto.getColour());
        vehicle.setModel(dto.getModel());
        vehicleRepo.save(vehicle);

        // 3. Save relationship
        VehicleOwner vo = new VehicleOwner();
        vo.setOwnerId(dto.getOwnerId());
        vo.setPlateNum(dto.getPlateNum());
        vehicleOwnerRepo.save(vo);
    }
}