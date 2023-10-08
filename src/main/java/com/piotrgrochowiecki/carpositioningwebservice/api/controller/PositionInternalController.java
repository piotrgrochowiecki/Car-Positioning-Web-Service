package com.piotrgrochowiecki.carpositioningwebservice.api.controller;

import com.piotrgrochowiecki.carpositioningwebservice.api.dto.PositionDto;
import com.piotrgrochowiecki.carpositioningwebservice.api.mapper.PositionApiMapper;
import com.piotrgrochowiecki.carpositioningwebservice.domain.exception.NotFoundException;
import com.piotrgrochowiecki.carpositioningwebservice.domain.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/internal/v1/position")
public class PositionInternalController {

    private final PositionService positionService;
    private final PositionApiMapper positionApiMapper;

    @Autowired
    public PositionInternalController(PositionService positionService, PositionApiMapper positionMapper) {
        this.positionService = positionService;
        this.positionApiMapper = positionMapper;
    }

    /**
     * Returns randomly generated position of a car with given UUID at current time and date. Also saves the record in database
     *
     * @param uuid uuid of requested car
     * @return position, time and date
     * @throws NotFoundException when no car with given uuid has been found
     */
    @GetMapping("current/{uuid}")
    public PositionDto getCurrentPositionOfACarByUuidAndSaveIt(@PathVariable @Nullable String uuid) throws NotFoundException {
        return positionService.getCurrentPositionOfACarByUuidAndSaveIt(uuid)
                .map(positionApiMapper::mapDomainToDto)
                .orElseThrow(() -> new NotFoundException("Car", uuid));
    }

}
