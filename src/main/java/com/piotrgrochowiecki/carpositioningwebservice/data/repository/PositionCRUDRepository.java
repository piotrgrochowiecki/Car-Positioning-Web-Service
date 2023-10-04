package com.piotrgrochowiecki.carpositioningwebservice.data.repository;

import com.piotrgrochowiecki.carpositioningwebservice.data.entity.PositionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionCRUDRepository extends CrudRepository<PositionEntity, Long> {

}
