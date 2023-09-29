package com.piotrgrochowiecki.carpositioningwebservice.repository;

import com.piotrgrochowiecki.carpositioningwebservice.entity.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Long> {

}
