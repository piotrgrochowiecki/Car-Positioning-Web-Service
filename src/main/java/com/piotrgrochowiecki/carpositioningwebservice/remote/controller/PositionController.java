package com.piotrgrochowiecki.carpositioningwebservice.remote.controller;

import com.piotrgrochowiecki.carpositioningwebservice.remote.dto.PositionDto;
import com.piotrgrochowiecki.carpositioningwebservice.remote.mapper.PositionApiMapper;
import com.piotrgrochowiecki.carpositioningwebservice.domain.exception.NotFoundRuntimeException;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import com.piotrgrochowiecki.carpositioningwebservice.domain.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/internal/v1/position")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;
    private final PositionApiMapper positionApiMapper;

    /**
     * Returns randomly generated position of a car with given UUID at current time and date. Also saves the record in database
     *
     * @param uuid uuid of requested car
     * @return position, time and date
     * @throws NotFoundRuntimeException when no car with given uuid has been found
     */
    @GetMapping("current/{uuid}")
    public PositionDto getCurrentPositionOfACarByUuidAndSaveIt(@PathVariable @Nullable String uuid) {
        Position position = positionService.getCurrentPositionOfACarByUuidAndSaveIt(uuid);
        return positionApiMapper.mapToDto(position);
    }
    //TODO teoretycznie GETem nie powinniśmy jeszcze czegoś zapisywać czego: ta metoda powinna tylko pobierać najnowszą dostępną pozycję samochodu.

}
