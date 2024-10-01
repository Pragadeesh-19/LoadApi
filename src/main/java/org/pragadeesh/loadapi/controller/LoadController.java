package org.pragadeesh.loadapi.controller;

import org.pragadeesh.loadapi.entity.Load;
import org.pragadeesh.loadapi.service.LoadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    @PostMapping("/{shipperId}")
    public ResponseEntity<String> createLoad(@PathVariable UUID shipperId,
                                             @RequestBody Load load) {
        loadService.createLoad(shipperId, load);
        return ResponseEntity.ok("Load Details added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Load>> getLoadByShipperId(@RequestParam UUID shipperId) {
        List<Load> loads = loadService.getLoadByShipperId(shipperId);
        return ResponseEntity.ok(loads);
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable UUID loadId,
                                             @RequestBody Load load) {
        loadService.updateLoad(loadId, load);
        return ResponseEntity.ok("Load updated Successfully");
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.noContent().build();
    }

}
