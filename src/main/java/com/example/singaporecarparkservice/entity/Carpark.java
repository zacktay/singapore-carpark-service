package com.example.singaporecarparkservice.entity;

import com.example.singaporecarparkservice.enums.CarparkType;
import com.example.singaporecarparkservice.enums.ParkingSystemType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@Entity
@Table(name = "carpark")
@NoArgsConstructor
@AllArgsConstructor
public class Carpark implements Serializable {

    private static final long serialVersionUID = -1235437464378655770L;

    @Id
    private String code;

    @Column
    private String address;

    @Column(name = "x_coord")
    private Double xCoord;

    @Column(name = "y_coord")
    private Double yCoord;

    @Column(name = "carpark_type")
    @Enumerated(EnumType.STRING)
    private CarparkType carparkType;

    @Column(name = "parking_system_type")
    @Enumerated(EnumType.STRING)
    private ParkingSystemType parkingSystemType;

    @Column(name = "short_term_parking")
    private String shortTermParking;

    @Column
    private String freeParking;

    @Column
    private Boolean night;

    @Column
    private Integer decks;

    @Column(name = "gantry_height")
    private Double gantryHeight;

    @Column
    private Boolean basement;

}
