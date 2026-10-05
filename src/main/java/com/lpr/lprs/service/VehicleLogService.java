package com.lpr.lprs.service;

import com.lpr.lprs.model.VehicleLog;
import com.lpr.lprs.repository.VehicleLogRepository;
import com.lpr.lprs.repository.VehicleOwnerRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VehicleLogService {

    private final VehicleLogRepository repo;
    private final VehicleOwnerRepository ownerRepo;

    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public VehicleLogService(VehicleLogRepository repo,
                              VehicleOwnerRepository ownerRepo) {
        this.repo = repo;
        this.ownerRepo = ownerRepo;
    }

    public List<Map<String, Object>> getLogs() {

        List<VehicleLog> logs = repo.findAll();

        return logs.stream().map(log -> {

            Map<String, Object> map = new HashMap<>();

            map.put("plateNum", log.getPlateNum());

            // entry time formatting
            map.put("entryTime",
                    log.getEntryTime() != null
                            ? log.getEntryTime().toLocalDateTime().format(formatter)
                            : "-");

            // exit time formatting
            map.put("exitTime",
                    log.getExitTime() != null
                            ? log.getExitTime().toLocalDateTime().format(formatter)
                            : null);

            // status logic
            map.put("status",
                    log.getExitTime() == null ? "INSIDE" : "EXITED");

            // registration check
            boolean isRegistered =
                    ownerRepo.existsByPlateNum(log.getPlateNum());

            map.put("registration",
                    isRegistered ? "REGISTERED" : "NOT REGISTERED");

            return map;

        }).collect(Collectors.toList());
    }
}