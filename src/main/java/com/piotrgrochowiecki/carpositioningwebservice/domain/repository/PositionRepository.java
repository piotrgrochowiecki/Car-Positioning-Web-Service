package com.piotrgrochowiecki.carpositioningwebservice.domain.repository;

import com.piotrgrochowiecki.carpositioningwebservice.data.repository.PositionCRUDRepository;
import com.piotrgrochowiecki.carpositioningwebservice.domain.mapper.PositionMapper;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PositionRepository {

    private final PositionCRUDRepository positionCRUDRepository;

    private final PositionMapper positionMapper;

    @Autowired
    public PositionRepository(PositionCRUDRepository positionCRUDRepository, PositionMapper positionMapper) {
        this.positionCRUDRepository = positionCRUDRepository;
        this.positionMapper = positionMapper;
    }

    public void add(Position position) {
        positionCRUDRepository.save(positionMapper.mapModelToEntity(position));
    }

}
