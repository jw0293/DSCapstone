package com.example.server.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBuildingPolygons is a Querydsl query type for BuildingPolygons
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBuildingPolygons extends EntityPathBase<BuildingPolygons> {

    private static final long serialVersionUID = -1459525506L;

    public static final QBuildingPolygons buildingPolygons = new QBuildingPolygons("buildingPolygons");

    public final StringPath address_id = createString("address_id");

    public final StringPath building_name = createString("building_name");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Float> lat = createNumber("lat", Float.class);

    public final NumberPath<Float> lon = createNumber("lon", Float.class);

    public QBuildingPolygons(String variable) {
        super(BuildingPolygons.class, forVariable(variable));
    }

    public QBuildingPolygons(Path<? extends BuildingPolygons> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBuildingPolygons(PathMetadata metadata) {
        super(BuildingPolygons.class, metadata);
    }

}

