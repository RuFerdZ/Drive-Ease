package com.backend.driveease;

import com.backend.driveease.model.Vehicle;
import com.backend.driveease.operations.VehicleOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class APIController {

    @Autowired
    VehicleOperations vehicleOperations;

    @GetMapping("/vehicles")
    public Object getAllVehicles() {
        return vehicleOperations.getAllVehicles();
    }

    @GetMapping("/vehicles/{id}")
    public Object getVehicleById(@PathVariable Long id) {
        return vehicleOperations.getVehicleById(id);
    }

    @PostMapping("/vehicles")
    public Object addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleOperations.addVehicle(vehicle);
    }

    @PutMapping("/vehicles/{id}")
    public Object updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleOperations.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/vehicles/{id}")
    public Object deleteVehicle(@PathVariable Long id) {
        return vehicleOperations.deleteVehicle(id);
    }

    @PostMapping("/vehicles/{id}/hire")
    public Object hireVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return vehicleOperations.hireVehicle(id, vehicle);
    }
}
