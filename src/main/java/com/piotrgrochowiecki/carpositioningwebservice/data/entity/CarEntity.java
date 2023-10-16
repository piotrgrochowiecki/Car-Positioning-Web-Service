package com.piotrgrochowiecki.carpositioningwebservice.data.entity;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Builder
@Table(name = "car",
       uniqueConstraints = @UniqueConstraint(columnNames = "uuid"))
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String uuid;

    String brand;

    String model;

    @ToString.Exclude
    @OneToMany(mappedBy = "carEntity")
    List<PositionEntity> positionEntityList;

}
