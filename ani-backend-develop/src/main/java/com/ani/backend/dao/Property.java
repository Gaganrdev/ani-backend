package com.ani.backend.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name = "Property")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long propertyId;


    @Column
    private String amenities;

    @Column
    private int balcony;

    @Column
    private int bathrooms;

    @Column
    private int bedrooms;

    @Column
    private String description;

    @Column
    private String flatNo;

    @Column
    private int kitchen;

    @Column
    private String propertyType;

    @Column
    private String title;

    @Column
    private int buildingId;

    @Column
    private int maxguestAllowes;

    

}
