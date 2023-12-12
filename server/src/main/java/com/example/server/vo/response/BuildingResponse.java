package com.example.server.vo.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Polygon;
import org.springframework.data.geo.Shape;

@Data
@AllArgsConstructor
public class BuildingResponse {

    private String address_id;

    private String sido;
    private String sigungu;
    private String eupmyeondong;

    private Float slope_avg;
    private Float slope_max;
    private Float slope_min;

    private String building_name;
    //private Polygon shape;
    private String construction_year;

    private String rent_type;
    private Long deposit;
    private Long rent;
}
