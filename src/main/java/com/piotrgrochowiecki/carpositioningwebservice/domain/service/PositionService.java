package com.piotrgrochowiecki.carpositioningwebservice.domain.service;

import com.piotrgrochowiecki.carpositioningwebservice.domain.exception.NotFoundRuntimeException;
import com.piotrgrochowiecki.carpositioningwebservice.domain.exception.ObjectType;
import com.piotrgrochowiecki.carpositioningwebservice.domain.model.Position;
import com.piotrgrochowiecki.carpositioningwebservice.domain.repository.CarRepository;
import com.piotrgrochowiecki.carpositioningwebservice.domain.repository.PositionRepository;
import com.piotrgrochowiecki.carpositioningwebservice.domain.service.supplier.GeoDataSupplier;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class PositionService {

    private final GeoDataSupplier geoDataSupplier;
    private final PositionRepository positionRepository;
    private final CarRepository carRepository;

    public Position getCurrentPositionOfACarByUuidAndSaveIt(@Nullable String uuid) {
        if (!carRepository.existsByUuid(uuid)){
            throw new NotFoundRuntimeException(ObjectType.CAR, uuid);
        }
        Position position = generatePosition(uuid);
        positionRepository.save(position);
        return position;
    }

    private Position generatePosition(String uuid) {
        return Position.builder()
                .latitude(geoDataSupplier.randomLatitudeSupplier.get())
                .longitude(geoDataSupplier.randomLongitudeSupplier.get())
                .time(LocalTime.now())
                .date(LocalDate.now())
                .carsUuid(uuid)
                .build();
    }

    //TODO zaimplementować zapisywanie pozycji wygenerowanej dla każdego samochodu w stałych odstępach czasowych. Przykład:

//    public class ScheduledTaskExample {
//
//        private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//
//        public void startScheduleTask() {
//            final Runnable task = new Runnable() {
//                public void run() {
//                    // call service method here
//                    saveRecordToDatabase();
//                }
//            };
//            final ScheduledFuture<?> taskHandle = scheduler.scheduleAtFixedRate(task, 0, 15, TimeUnit.MINUTES);
//        }
//
//        private void saveRecordToDatabase() {
//            // implementation of database save operation
//        }
//    }

}
