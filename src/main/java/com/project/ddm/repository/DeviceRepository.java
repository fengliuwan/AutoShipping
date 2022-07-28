package com.project.ddm.repository;

import com.project.ddm.model.Device;
import com.project.ddm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByUser(User user);
}
