package com.project.ddm.repository;

import com.project.ddm.model.Device;
import com.project.ddm.model.DeviceReserveDate;
import com.project.ddm.model.DeviceReservedDateKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Repository
public interface DeviceReserveDateRepository extends JpaRepository<DeviceReserveDate, DeviceReservedDateKey> {
    @Query(value = "SELECT srd.id.deviceId FROM DeviceReserveDate srd WHERE srd.id.deviceId IN ?1 AND srd.id.date BETWEEN ?2 AND ?3 GROUP BY srd.id.deviceId")
    Set<Long> findByIdInAndDateBetween(List<Long> deviceIds, LocalDate startDate, LocalDate endDate);


}