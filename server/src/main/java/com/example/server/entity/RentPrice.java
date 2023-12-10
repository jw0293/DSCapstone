package com.example.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RentPrice {

    @Id
    private String address_id;

    @Column
    private String sido;

    @Column
    private String sigungu;

    @Column
    private String eupmyeondong;

    @Column
    private String building_name;

    @Column
    private String construction_year;

    @Column
    private String rent_type;

    @Column
    private Long deposit;

    @Column
    private Long rent;
}
