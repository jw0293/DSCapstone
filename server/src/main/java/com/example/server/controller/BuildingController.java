package com.example.server.controller;

import com.example.server.entity.BuildingPolygons;
import com.example.server.service.BuildingService;
import com.example.server.vo.request.BuildingRequest;
import com.example.server.vo.request.MapPositionRequest;
import com.example.server.vo.response.BuildingPriceResponse;
import com.example.server.vo.response.BuildingResponse;
import com.example.server.vo.response.BuildingsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;

    @GetMapping("/map")
    public List<BuildingsResponse> basicScreen(@ModelAttribute MapPositionRequest mapPositionRequest){
        return buildingService.findAllBuildings(mapPositionRequest);
    }

    @GetMapping("/map/building")
    public BuildingResponse getBuildingInformation(@RequestParam(value="address_id", required = false, defaultValue = "1111010100100040100") String address_id){
        log.info("Building AddressId : {}", address_id);
        return buildingService.createBuildingDto(address_id);
    }

    @GetMapping("/map/price")
    public List<BuildingPriceResponse> getBuildingPrice(@RequestParam(value="address_id", required = false, defaultValue = "1111010100100040100") String address_id){
        return buildingService.createBuildingPriceResponse(address_id);
    }
}
