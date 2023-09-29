package com.piotrgrochowiecki.carpositioningwebservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String brand;

    String model;

    @OneToMany(mappedBy = "car")
    List<Position> positionList;

}
