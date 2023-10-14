package com.piotrgrochowiecki.carpositioningwebservice.domain.repository;

import com.piotrgrochowiecki.carpositioningwebservice.data.repository.PositionCRUDRepository;
import com.piotrgrochowiecki.carpositioningwebservice.domain.mapper.PositionMapper;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository {

    void save(Position position);
}
