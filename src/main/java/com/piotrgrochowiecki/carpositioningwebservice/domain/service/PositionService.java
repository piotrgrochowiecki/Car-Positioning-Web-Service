package com.piotrgrochowiecki.carpositioningwebservice.domain.service;

import com.piotrgrochowiecki.carpositioningwebservice.domain.exception.NotFoundException;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import com.piotrgrochowiecki.carpositioningwebservice.domain.repository.CarRepository;
import com.piotrgrochowiecki.carpositioningwebservice.domain.repository.PositionRepository;
import com.piotrgrochowiecki.carpositioningwebservice.domain.service.supplier.GeoDataSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class PositionService {

    private final GeoDataSupplier geoDataSupplier;
    private final PositionRepository positionRepository;
    private final CarRepository carRepository;

    @Autowired
    public PositionService(GeoDataSupplier geoDataSupplier, PositionRepository positionRepository, CarRepository carRepository) {
        this.geoDataSupplier = geoDataSupplier;
        this.positionRepository = positionRepository;
        this.carRepository = carRepository;
    }
    public Optional<Position> getCurrentPositionOfACarByUuidAndSaveIt(@Nullable String uuid) throws NotFoundException {
        if (!carRepository.existsByUuid(uuid)){
            return Optional.empty();
        }
        Position position = generatePosition(uuid);
        positionRepository.save(position);
        return Optional.of(position);
    }

    private Position generatePosition(String uuid) {
        return Position.builder()
                .latitude(geoDataSupplier.randomLatitudeSupplier.get())
                .longitude(geoDataSupplier.randomLongitudeSupplier.get())
                .time(LocalTime.now())
                .date(LocalDate.now())
                .carsUuid(uuid)
                .build();
    }

}
