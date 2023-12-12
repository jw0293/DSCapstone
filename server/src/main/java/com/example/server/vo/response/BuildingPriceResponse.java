package com.example.server.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuildingPriceResponse {

    private String date;
    private String rent_type;
    private Long deposit;
    private Long rent;
    private String address_id;
    private String building_name;

}
