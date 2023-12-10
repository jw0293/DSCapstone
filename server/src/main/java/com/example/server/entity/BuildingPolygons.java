package com.example.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.geo.Polygon;

@Entity
@Data
public class BuildingPolygons {

    @Id
    private Long id;

//    @Column
//    private Polygon shape;

    @Column
    private String address_id;

    @Column
    private Float lat;

    @Column
    private Float lon;

    @Column
    private String building_name;
}
