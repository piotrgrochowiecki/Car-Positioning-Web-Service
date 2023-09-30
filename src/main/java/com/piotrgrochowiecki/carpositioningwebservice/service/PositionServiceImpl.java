package com.piotrgrochowiecki.carpositioningwebservice.service;

import com.piotrgrochowiecki.carpositioningwebservice.entity.Car;
import com.piotrgrochowiecki.carpositioningwebservice.entity.Position;
import com.piotrgrochowiecki.carpositioningwebservice.service.supplier.GeoDataSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Position service implementation
 */
@Service
public class PositionServiceImpl implements PositionService {

    private final GeoDataSupplier geoDataSupplier;

    /**
     * Constructor
     *
     * @param geoDataSupplier Supplier of geographical coordinates
     */
    @Autowired
    public PositionServiceImpl(GeoDataSupplier geoDataSupplier) {
        this.geoDataSupplier = geoDataSupplier;
    }


    /**
     * Provides position with randomly generated longitude and latitude for current time and date
     *
     * @param car car for which position is generated
     * @return randomly generated position
     */
    @Override
    public Position getCurrentRandomPosition(Car car) {
        return Position.builder()
                .car(car)
                .latitude(geoDataSupplier.randomLatitudeSupplier.get())
                .longitude(geoDataSupplier.randomLongitudeSupplier.get())
                .time(LocalTime.now())
                .date(LocalDate.now())
                .build();
    }

}
