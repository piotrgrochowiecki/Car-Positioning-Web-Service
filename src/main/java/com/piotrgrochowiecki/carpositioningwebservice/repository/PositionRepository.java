package com.piotrgrochowiecki.carpositioningwebservice.repository;

import com.piotrgrochowiecki.carpositioningwebservice.entity.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Position repository
 */
@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {

}
