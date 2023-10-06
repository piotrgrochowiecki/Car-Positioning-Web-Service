package com.piotrgrochowiecki.carpositioningwebservice.domain.service;

import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import com.piotrgrochowiecki.carpositioningwebservice.domain.repository.PositionRepository;
import com.piotrgrochowiecki.carpositioningwebservice.domain.service.supplier.GeoDataSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class PositionService {

    private final GeoDataSupplier geoDataSupplier;

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(GeoDataSupplier geoDataSupplier, PositionRepository positionRepository) {
        this.geoDataSupplier = geoDataSupplier;
        this.positionRepository = positionRepository;
    }

    public Position getCurrentPositionOfACarByUuidAndSaveIt(String uuid) {
        Position position = Position.builder()
                .latitude(geoDataSupplier.randomLatitudeSupplier.get())
                .longitude(geoDataSupplier.randomLongitudeSupplier.get())
                .time(LocalTime.now())
                .date(LocalDate.now())
                .carsUuid(uuid)
                .build();

        positionRepository.save(position);
        return position;
    }

}
