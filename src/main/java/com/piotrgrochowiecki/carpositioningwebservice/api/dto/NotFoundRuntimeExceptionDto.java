package com.piotrgrochowiecki.carpositioningwebservice.api.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NotFoundRuntimeExceptionDto(String message, LocalDateTime timeStamp) {

}
