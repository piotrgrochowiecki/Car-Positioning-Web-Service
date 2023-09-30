package com.piotrgrochowiecki.carpositioningwebservice.entity;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Car entity
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {

    @Id
    String uuid;

    String brand;

    String model;

    @ToString.Exclude
    @OneToMany(mappedBy = "car")
    List<Position> positionList;

}
