package com.example.server.repository.BuildingPolygons;

import com.example.server.vo.request.MapPositionRequest;
import com.example.server.vo.response.BuildingResponse;
import com.example.server.vo.response.BuildingsResponse;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BuildingPolygonsRepository{
    private final EntityManager em;

    public BuildingResponse findByAddressId(String addressId) {
        String jpqlQuery = "SELECT NEW com.example.server.vo.response.BuildingResponse(" +
                "ls.address_id, " +
                "ls.sido, " +
                "ls.sigungu, " +
                "ls.eupmyeondong, " +
                "ls.slope_avg, " +
                "ls.slope_max, " +
                "ls.slope_min, " +
                "rp.building_name, " +
                //"ST_AsText(ls.shape) AS shape, " +
                "rp.construction_year, " +
                "rp.rent_type, " +
                "rp.deposit, " +
                "rp.rent) " +
                "FROM LandSlope ls, RentPrice rp " +
                "WHERE ls.address_id = rp.address_id AND ls.address_id = :addressId " +
                "GROUP BY " +
                "ls.address_id, " +
                "ls.sido, " +
                "ls.sigungu, " +
                "ls.eupmyeondong, " +
                "ls.slope_avg, " +
                "ls.slope_max, " +
                "ls.slope_min, " +
                "rp.building_name, " +
                //"shape, " +
                "rp.construction_year, " +
                "rp.rent_type, " +
                "rp.deposit, " +
                "rp.rent";

        return em.createQuery(jpqlQuery, BuildingResponse.class)
                .setParameter("addressId", addressId)
                .getResultList().get(0);
    }

    public List<BuildingsResponse> findAllBuildings(MapPositionRequest mapPositionRequest) {
        Float leftBottomLon = mapPositionRequest.getLeftBottomLon();
        Float leftBottomLat = mapPositionRequest.getLeftBottomLat();

        Float rightTopLon = mapPositionRequest.getRightTopLon();
        Float rightTopLat = mapPositionRequest.getRightTopLat();

        String qquery = "SELECT DISTINCT NEW com.example.server.vo.response.BuildingsResponse(bp.address_id, rp.building_name, rp.rent_type, rp.deposit, rp.rent, rp.construction_year, bp.lat, bp.lon) " +
                "FROM RentPrice rp, BuildingPolygons bp " +
                "WHERE rp.address_id = bp.address_id AND (bp.lon > :leftBottomLon AND bp.lon < :rightTopLon) AND (bp.lat > :leftBottomLat AND bp.lat < :rightTopLat) " +
                "GROUP BY bp.address_id " +
                "ORDER BY bp.address_id ";

        return em.createQuery(qquery, BuildingsResponse.class)
                .setParameter("leftBottomLon", leftBottomLon)
                .setParameter("rightTopLon", rightTopLon)
                .setParameter("leftBottomLat", leftBottomLat)
                .setParameter("rightTopLat", rightTopLat)
                .setMaxResults(50)
                .getResultList();
    }
}
