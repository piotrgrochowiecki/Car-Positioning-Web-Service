package com.piotrgrochowiecki.carpositioningwebservice.service.supplier;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.function.Supplier;

/**
 * Supplier class of random geographic coordinates within Polish max and min values
 */
@Component
public class GeoDataSupplier {

    /**
     * Supplies randomly generated latitude information between 49°00’N (49.00) and 54°50’N (54.5)
     */
    public Supplier<Double> randomLatitudeSupplier = () -> {
        Random random = new Random();
        return (Double) random.nextDouble(49.0, 54.5);
    };

    /**
     * Supplies randomly generated longitude information between 14°07’E (14.07) and 24°09’E (24.09)
     */
    public Supplier<Double> randomLongitudeSupplier = () -> {
        Random random = new Random();
        return (Double) random.nextDouble(14.07, 24.09);
    };

}
