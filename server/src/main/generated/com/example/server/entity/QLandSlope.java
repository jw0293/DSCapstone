package com.example.server.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLandSlope is a Querydsl query type for LandSlope
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLandSlope extends EntityPathBase<LandSlope> {

    private static final long serialVersionUID = -1494056849L;

    public static final QLandSlope landSlope = new QLandSlope("landSlope");

    public final StringPath address_id = createString("address_id");

    public final StringPath eupmyeondong = createString("eupmyeondong");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SimplePath<org.springframework.data.geo.Shape> shape = createSimple("shape", org.springframework.data.geo.Shape.class);

    public final StringPath sido = createString("sido");

    public final StringPath sigungu = createString("sigungu");

    public final NumberPath<Float> slope_avg = createNumber("slope_avg", Float.class);

    public final NumberPath<Float> slope_max = createNumber("slope_max", Float.class);

    public final NumberPath<Float> slope_min = createNumber("slope_min", Float.class);

    public QLandSlope(String variable) {
        super(LandSlope.class, forVariable(variable));
    }

    public QLandSlope(Path<? extends LandSlope> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLandSlope(PathMetadata metadata) {
        super(LandSlope.class, metadata);
    }

}

