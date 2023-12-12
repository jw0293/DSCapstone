package com.example.server.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRentPrice is a Querydsl query type for RentPrice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRentPrice extends EntityPathBase<RentPrice> {

    private static final long serialVersionUID = -617106561L;

    public static final QRentPrice rentPrice = new QRentPrice("rentPrice");

    public final StringPath address_id = createString("address_id");

    public final StringPath building_name = createString("building_name");

    public final StringPath construction_year = createString("construction_year");

    public final StringPath contract_date = createString("contract_date");

    public final NumberPath<Long> deposit = createNumber("deposit", Long.class);

    public final StringPath eupmyeondong = createString("eupmyeondong");

    public final NumberPath<Long> rent = createNumber("rent", Long.class);

    public final StringPath rent_type = createString("rent_type");

    public final StringPath sido = createString("sido");

    public final StringPath sigungu = createString("sigungu");

    public QRentPrice(String variable) {
        super(RentPrice.class, forVariable(variable));
    }

    public QRentPrice(Path<? extends RentPrice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRentPrice(PathMetadata metadata) {
        super(RentPrice.class, metadata);
    }

}

