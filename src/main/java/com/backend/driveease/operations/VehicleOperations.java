package com.backend.driveease.operations;

import com.backend.driveease.dao.VehicleDao;
import com.backend.driveease.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleOperations {

    @Autowired
    private VehicleDao vehicleDao;

    public ResponseEntity<?> getAllVehicles() {
        return ResponseEntity.ok(vehicleDao.findAll());
    }

    public ResponseEntity<?> getVehicleById(Long id) {
        if (!vehicleDao.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vehicleDao.findById(id));
    }

    public ResponseEntity<?> addVehicle(Vehicle vehicle) {
        return ResponseEntity.ok(vehicleDao.save(vehicle));
    }

    public ResponseEntity<?> updateVehicle(Long id, Vehicle vehicle) {
        if (!vehicleDao.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Vehicle vehicleToUpdate = vehicleDao.findById(id).get();
        vehicleToUpdate.setName(vehicle.getName());
        vehicleToUpdate.setPrice(vehicle.getPrice());
        vehicleToUpdate.setPickupLocation(vehicle.getPickupLocation());
        vehicleToUpdate.setDropLocation(vehicle.getDropLocation());
        vehicleToUpdate.setPickupDate(vehicle.getPickupDate());
        vehicleToUpdate.setReturnDate(vehicle.getReturnDate());
        return ResponseEntity.ok(vehicleDao.save(vehicleToUpdate));
    }

    public ResponseEntity<?> deleteVehicle(Long id) {
        if (!vehicleDao.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        vehicleDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<?> hireVehicle(Long id, Vehicle vehicle) {
        if (!vehicleDao.findById(id).isPresent()) {
            return ResponseEntity.ok("Vehicle not found");
        }

        Vehicle vehicleToUpdate = vehicleDao.findById(id).get();

        if (vehicleToUpdate.getPickupDate() != null) {
            return ResponseEntity.ok("Vehicle already hired");
        }

        vehicleToUpdate.setPickupLocation(vehicle.getPickupLocation());
        vehicleToUpdate.setDropLocation(vehicle.getDropLocation());
        vehicleToUpdate.setPickupDate(vehicle.getPickupDate());
        vehicleToUpdate.setReturnDate(vehicle.getReturnDate());
        return ResponseEntity.ok(vehicleDao.save(vehicleToUpdate));
    }
}
