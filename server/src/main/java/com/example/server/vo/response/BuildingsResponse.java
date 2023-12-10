package com.example.server.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.geo.Polygon;

@Data
@AllArgsConstructor
public class BuildingsResponse {

    private String address_id;
    //private Polygon shape;
    private String Building_name;
    private String rent_type;
    private Long deposit;
    private Long rent;
    private String construction_year;
    private Float lat;
    private Float lon;
}
