package org.iesvdm.haversine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TODOTEST {
    @Test
    public void testHaversineDistance() {
        TODO.Posicion posOrigen = new TODO.Posicion(new BigDecimal("52.5200"), new BigDecimal("13.4050"));
        TODO.Posicion posDestino = new TODO.Posicion(new BigDecimal("48.8566"), new BigDecimal("2.3522"));

        // Expected distance obtained from a reliable source
        BigDecimal expectedDistance = new BigDecimal("878.93");

        // Calculate the actual distance
        BigDecimal actualDistance = TODO.Haversine.distanciaKm(posOrigen, posDestino);

        // Define a delta for the comparison due to potential rounding differences
        BigDecimal delta = new BigDecimal("0.01");

        // Compare the actual distance to the expected distance with a delta
        Assertions.assertEquals(expectedDistance, actualDistance, String.valueOf(delta));
    }
}
