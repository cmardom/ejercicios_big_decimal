package org.iesvdm.haversine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TODOTEST {
    @Test
    public void testHaversineDistance() {
        TODO.Posicion posOrigen = new TODO.Posicion(new BigDecimal("52.5200"), new BigDecimal("13.4050"));
        TODO.Posicion posDestino = new TODO.Posicion(new BigDecimal("48.8566"), new BigDecimal("2.3522"));

        //Distancia esperada
        BigDecimal distanciaEsperada = new BigDecimal("878.93");

        // Calculate calcular distancia real
        BigDecimal distanciaReal = TODO.Haversine.distanciaKm(posOrigen, posDestino);

        // Definir delta
        BigDecimal delta = new BigDecimal("0.01");

        // Comparar distancia esperada con distancia real y delta
        Assertions.assertEquals(distanciaEsperada, distanciaReal, String.valueOf(delta));
    }
}
