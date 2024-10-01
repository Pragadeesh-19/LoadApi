package org.pragadeesh.loadapi.service;

import jakarta.persistence.EntityNotFoundException;
import org.pragadeesh.loadapi.entity.Load;
import org.pragadeesh.loadapi.entity.Shipper;
import org.pragadeesh.loadapi.repository.LoadRepository;
import org.pragadeesh.loadapi.repository.ShipperRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {

    private final LoadRepository loadRepository;
    private final ShipperRepository shipperRepository;

    public LoadService(LoadRepository loadRepository, ShipperRepository shipperRepository) {
        this.loadRepository = loadRepository;
        this.shipperRepository = shipperRepository;
    }

    public Load createLoad(UUID shipperId, Load load) {
        Shipper shipper = shipperRepository.findById(shipperId)
                .orElseThrow(() -> new EntityNotFoundException("Shipper not found!!"));

        load.setShipper(shipper);
        return loadRepository.save(load);
    }

    public List<Load> getLoadByShipperId(UUID shipperId) {
        return loadRepository.findByShipper_ShipperId(shipperId);
    }

    public Optional<Load> getLoadById(UUID loadId) {
        return loadRepository.findById(loadId);
    }

    public Load updateLoad(UUID loadId, Load updatedLoad) {
        return loadRepository.findById(loadId).map(load -> {
            load.setLoadingPoint(updatedLoad.getLoadingPoint());
            load.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            load.setProductType(updatedLoad.getProductType());
            load.setTruckType(updatedLoad.getTruckType());
            load.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            load.setWeight(updatedLoad.getWeight());
            load.setComment(updatedLoad.getComment());
            load.setDate(LocalDateTime.now());
            return loadRepository.save(load);
        }).orElseThrow(() -> new EntityNotFoundException("Load not found!!"));
    }

    public void deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
    }
}
