package org.pragadeesh.loadapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Load {

    @Id
    @GeneratedValue
    private UUID loadId;

    @Column(nullable = false)
    private String loadingPoint;

    @Column(nullable = false)
    private String unloadingPoint;

    @Column(nullable = false)
    private String productType;

    @Column(nullable = false)
    private String truckType;

    @Column(nullable = false)
    private int noOfTrucks;

    @Column(nullable = false)
    private float weight;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "shipperId", nullable = false)
    private Shipper shipper;

    private LocalDateTime date;


}
