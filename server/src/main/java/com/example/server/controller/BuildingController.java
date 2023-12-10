package com.example.server.controller;

import com.example.server.entity.BuildingPolygons;
import com.example.server.service.BuildingService;
import com.example.server.vo.request.BuildingRequest;
import com.example.server.vo.request.MapPositionRequest;
import com.example.server.vo.response.BuildingResponse;
import com.example.server.vo.response.BuildingsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;

    @GetMapping("/map")
    public List<BuildingsResponse> basicScreen(@RequestBody MapPositionRequest mapPositionRequest){
        return buildingService.findAllBuildings(mapPositionRequest);
    }

    @GetMapping("/map/building")
    public BuildingResponse getBuildingInformation(@RequestBody BuildingRequest buildingRequest){
        log.info("Building AddressId : {}", buildingRequest.getAddressId());
        return buildingService.createBuildingDto(buildingRequest.getAddressId());
    }

}
