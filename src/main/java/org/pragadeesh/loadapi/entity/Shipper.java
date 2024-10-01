package org.pragadeesh.loadapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Shipper {

    @Id
    @GeneratedValue
    private UUID shipperId;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "shipper", cascade = CascadeType.ALL)
    private List<Load> loads = new ArrayList<>();
}
