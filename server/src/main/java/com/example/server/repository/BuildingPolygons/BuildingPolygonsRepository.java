package com.example.server.repository.BuildingPolygons;

import com.example.server.vo.request.MapPositionRequest;
import com.example.server.vo.response.BuildingPriceResponse;
import com.example.server.vo.response.BuildingResponse;
import com.example.server.vo.response.BuildingsResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
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
                //"St_AsText(ls.shape) AS shape, " +
                //"ASTEXT(ls.shape) AS shape, " +
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

        log.info("leftBottomLon : {}", leftBottomLon);
        log.info("leftBottomLat : {}",leftBottomLat);
        log.info("rightTopLon : {}", rightTopLon);
        log.info("rightTopLat : {}", rightTopLat);

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

    public List<BuildingPriceResponse> findBuildingPriceByAddressId(String addressId) {
        log.info("Price : {}", addressId);
        List<BuildingPriceResponse> first = getInformation(addressId, "전세");
        List<BuildingPriceResponse> second = getInformation(addressId, "월세");

        List<BuildingPriceResponse> result = new ArrayList<>();
        result.addAll(first);
        result.addAll(second);

        return result;
    }

    private List<BuildingPriceResponse> getInformation(String addressId, String rentType) {
        String jpqlQuery = "SELECT DISTINCT NEW com.example.server.vo.response.BuildingPriceResponse(SUBSTRING(contract_date, 1, 4) date, " +
                "rent_type, deposit, rent, address_id, building_name) " +
                "FROM RentPrice " +
                "WHERE address_id = :addressId and rent_type = :rentType " +
                "GROUP BY date " +
                "ORDER BY date ";

        TypedQuery<BuildingPriceResponse> query = em.createQuery(jpqlQuery, BuildingPriceResponse.class)
                .setParameter("addressId", addressId)
                .setParameter("rentType", rentType);

        return query.getResultList();
    }
}
