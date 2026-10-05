package com.lpr.lprs.repository;

import com.lpr.lprs.dto.VehicleOwnerDTO;
import com.lpr.lprs.model.VehicleOwner;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface VehicleOwnerRepository extends JpaRepository<VehicleOwner, String> {

    boolean existsByPlateNum(String plateNum);

    @Query("""
        SELECT new com.lpr.lprs.dto.VehicleOwnerDTO(
            v.plateNum,
            v.ownerId,
            o.name,
            o.type
        )
        FROM VehicleOwner v
        JOIN Owner o ON v.ownerId = o.ownerId
    """)
    List<VehicleOwnerDTO> getVehicleOwnerData();
}