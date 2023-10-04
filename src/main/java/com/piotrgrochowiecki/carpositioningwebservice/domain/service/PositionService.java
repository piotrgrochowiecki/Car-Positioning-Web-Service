package com.piotrgrochowiecki.carpositioningwebservice.domain.service;

import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Car;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import com.piotrgrochowiecki.carpositioningwebservice.domain.service.supplier.GeoDataSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class PositionService {

    private final GeoDataSupplier geoDataSupplier;
    private final CarService carService;

    @Autowired
    public PositionService(GeoDataSupplier geoDataSupplier, CarService carService) {
        this.geoDataSupplier = geoDataSupplier;
        this.carService = carService;
    }

    public Position getCurrentPositionOfACarByUuid(String uuid) {
        Car car = carService.getByUuid(uuid);
        return Position.builder()
                .car(car)
                .latitude(geoDataSupplier.randomLatitudeSupplier.get())
                .longitude(geoDataSupplier.randomLongitudeSupplier.get())
                .time(LocalTime.now())
                .date(LocalDate.now())
                .build();
    }

}
