package org.pragadeesh.loadapi.repository;

import org.pragadeesh.loadapi.entity.Load;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LoadRepository extends JpaRepository<Load, UUID> {

    List<Load> findByShipper_ShipperId(UUID shipperId);
}
