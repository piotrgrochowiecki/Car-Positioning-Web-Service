package com.piotrgrochowiecki.carpositioningwebservice.service;

import com.piotrgrochowiecki.carpositioningwebservice.entity.Car;
import com.piotrgrochowiecki.carpositioningwebservice.entity.Position;

/**
 * Position service
 */
public interface PositionService {

    Position getCurrentRandomPosition(Car car);

}
