package com.example.server.vo.request;

import lombok.Data;

@Data
public class MapPositionRequest {

    private Float leftBottomLon;
    private Float leftBottomLat;

    private Float rightTopLon;
    private Float rightTopLat;
}
