package com.example.server.service;

import com.example.server.entity.BuildingPolygons;
import com.example.server.repository.BuildingPolygons.BuildingPolygonsRepository;
import com.example.server.vo.request.MapPositionRequest;
import com.example.server.vo.response.BuildingResponse;
import com.example.server.vo.response.BuildingsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingPolygonsRepository buildingPolygonsRepository;

//    public ResponseEntity<?> getAllBuildings(MapPositionRequest requestPoint){
//
//    }

    public BuildingResponse createBuildingDto(String addressId) {
        return buildingPolygonsRepository.findByAddressId(addressId);
    }

    public List<BuildingsResponse> findAllBuildings(MapPositionRequest mapPositionRequest) {
        return buildingPolygonsRepository.findAllBuildings(mapPositionRequest);
    }
}