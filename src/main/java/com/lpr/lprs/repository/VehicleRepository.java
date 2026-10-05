package com.lpr.lprs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpr.lprs.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}