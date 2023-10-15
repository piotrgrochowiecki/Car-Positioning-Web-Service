package com.piotrgrochowiecki.carpositioningwebservice.domain.repository;

import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository {

    void save(Position position);
}
