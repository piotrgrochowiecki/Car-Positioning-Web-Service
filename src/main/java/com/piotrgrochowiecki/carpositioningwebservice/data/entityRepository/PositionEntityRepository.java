package com.piotrgrochowiecki.carpositioningwebservice.data.entityRepository;

import com.piotrgrochowiecki.carpositioningwebservice.data.repository.PositionCRUDRepository;
import com.piotrgrochowiecki.carpositioningwebservice.domain.mapper.PositionMapper;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import com.piotrgrochowiecki.carpositioningwebservice.domain.repository.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PositionEntityRepository implements PositionRepository {

    private final PositionCRUDRepository positionCRUDRepository;
    private final PositionMapper positionMapper;

    public void save(Position position){
        positionCRUDRepository.save(positionMapper.mapModelToEntity(position));
    }


}
