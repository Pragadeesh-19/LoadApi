package org.pragadeesh.loadapi.service;

import jakarta.persistence.EntityNotFoundException;
import org.pragadeesh.loadapi.entity.Shipper;
import org.pragadeesh.loadapi.repository.ShipperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShipperService {

    private final ShipperRepository shipperRepository;

    public ShipperService(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    public Shipper createShipper(Shipper shipper) {
        return shipperRepository.save(shipper);
    }

    public Optional<Shipper> getShipperById(UUID shipperId) {
        return shipperRepository.findById(shipperId);
    }

    public List<Shipper> getAllShipper() {
        return shipperRepository.findAll();
    }

    public Shipper updateShipper(UUID shipperId, Shipper updatedShipper) {
        return shipperRepository.findById(shipperId).map(ship -> {
            ship.setName(updatedShipper.getName());
            return shipperRepository.save(ship);
        }).orElseThrow(() -> new EntityNotFoundException("Entity not found with Id"));
    }

    public void deleteShipper(UUID shipperId) {
        shipperRepository.deleteById(shipperId);
    }
}
