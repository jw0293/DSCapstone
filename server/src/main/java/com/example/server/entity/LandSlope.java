package com.example.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Shape;

@Entity
@Data
public class LandSlope {

    @Id
    private Long id;

    @Column
    private String address_id;

    @Column
    private String sido;

    @Column
    private String sigungu;

    @Column
    private String eupmyeondong;

    @Column
    private Float slope_avg;

    @Column
    private Float slope_min;

    @Column
    private Float slope_max;

    @Column
    private Shape shape;

}
