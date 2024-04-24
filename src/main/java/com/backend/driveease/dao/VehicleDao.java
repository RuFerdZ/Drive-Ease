package com.backend.driveease.dao;

import com.backend.driveease.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleDao extends CrudRepository<Vehicle, Long> {

}
