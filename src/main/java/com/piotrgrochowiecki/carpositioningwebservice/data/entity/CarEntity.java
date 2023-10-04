package com.piotrgrochowiecki.carpositioningwebservice.data.entity;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Builder
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarEntity {

    @Id
    String uuid;

    String brand;

    String model;

    @ToString.Exclude
    @OneToMany(mappedBy = "carEntity")
    List<PositionEntity> positionEntityList;

}
