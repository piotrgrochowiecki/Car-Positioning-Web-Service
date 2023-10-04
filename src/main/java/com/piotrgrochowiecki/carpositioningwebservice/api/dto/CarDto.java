package com.piotrgrochowiecki.carpositioningwebservice.api.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CarDto(String uuid, String brand, String model, List<PositionDto> positionDtoList) {

}
