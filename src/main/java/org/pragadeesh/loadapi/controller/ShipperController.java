package org.pragadeesh.loadapi.controller;

import org.pragadeesh.loadapi.entity.Shipper;
import org.pragadeesh.loadapi.service.ShipperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shipper")
public class ShipperController {

    private final ShipperService shipperService;

    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @PostMapping
    public ResponseEntity<String> createShipper(@RequestBody Shipper shipper) {
        shipperService.createShipper(shipper);
        return ResponseEntity.ok("Shipper added Successfully");
    }

    @GetMapping("/{shipperId}")
    public ResponseEntity<Shipper> getShipperId(@PathVariable UUID shipperId) {
        Shipper shipper = shipperService.getShipperById(shipperId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(shipper);
    }

    @GetMapping
    public ResponseEntity<List<Shipper>> getAllShipper() {
        List<Shipper> shipper = shipperService.getAllShipper();
        return ResponseEntity.ok(shipper);
    }

    @PutMapping("/{shipperId}")
    public ResponseEntity<String> updateShipper(@PathVariable UUID shipperId,
                                                @RequestBody Shipper shipper) {
        shipperService.updateShipper(shipperId, shipper);
        return ResponseEntity.ok("Shipper updated Successfully");
    }

    @DeleteMapping("/{shipperId}")
    public ResponseEntity<Void> deleteShipper(@PathVariable UUID shipperId) {
        shipperService.deleteShipper(shipperId);
        return ResponseEntity.noContent().build();
    }
}
