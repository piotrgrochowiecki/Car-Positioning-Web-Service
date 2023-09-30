package com.piotrgrochowiecki.carpositioningwebservice.controller;

import com.piotrgrochowiecki.carpositioningwebservice.entity.Car;
import com.piotrgrochowiecki.carpositioningwebservice.entity.Position;
import com.piotrgrochowiecki.carpositioningwebservice.exception.CarNotFoundException;
import com.piotrgrochowiecki.carpositioningwebservice.service.CarService;
import com.piotrgrochowiecki.carpositioningwebservice.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Position REST controller
 */
@RestController
@RequestMapping("api/position")
public class PositionController {

    private final PositionService positionService;
    private final CarService carService;

    /**
     * Constructor
     *
     * @param positionService position service
     * @param carService car service
     */
    @Autowired
    public PositionController(PositionService positionService, CarService carService) {
        this.positionService = positionService;
        this.carService = carService;
    }

    /**
     * Returns Position object with randomly generated longitude and latitude at current time and date for a car with given UUID
     *
     * @param uuid UUID of the car
     * @return Position object
     * @throws CarNotFoundException when car with given UUID could not be found
     */
    @GetMapping("current/{uuid}")
    public Position getCurrentPosition(@PathVariable String uuid) throws CarNotFoundException {
        Optional<Car> carOptional = carService.getByUuid(uuid);
        Car car = carOptional.orElseThrow(() -> new CarNotFoundException(uuid));
        return positionService.getCurrentRandomPosition(car);
    }

}
