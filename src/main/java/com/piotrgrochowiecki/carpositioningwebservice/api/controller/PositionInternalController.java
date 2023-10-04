package com.piotrgrochowiecki.carpositioningwebservice.api.controller;

import com.piotrgrochowiecki.carpositioningwebservice.api.dto.PositionDto;
import com.piotrgrochowiecki.carpositioningwebservice.api.mapper.PositionApiMapper;
import com.piotrgrochowiecki.carpositioningwebservice.domain.exception.NotFoundException;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import com.piotrgrochowiecki.carpositioningwebservice.domain.service.CarService;
import com.piotrgrochowiecki.carpositioningwebservice.domain.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/internal/v1/position")
public class PositionInternalController {

    private final PositionService positionService;
    private final CarService carService;
    private final PositionApiMapper positionApiMapper;

    @Autowired
    public PositionInternalController(PositionService positionService, CarService carService, PositionApiMapper positionMapper) {
        this.positionService = positionService;
        this.carService = carService;
        this.positionApiMapper = positionMapper;
    }

    @GetMapping("current/{uuid}")
    public PositionDto getCurrentPosition(@PathVariable String uuid) throws NotFoundException {
        Position position = positionService.getCurrentPositionOfACarByUuid(uuid);
        return positionApiMapper.mapDomainToDto(position);
    }

}
