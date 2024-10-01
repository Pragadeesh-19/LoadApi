package org.pragadeesh.loadapi.repository;

import org.pragadeesh.loadapi.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, UUID> {

}
