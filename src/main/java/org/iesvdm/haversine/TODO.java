package org.iesvdm.haversine;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class TODO {

    public static class Posicion {
        private BigDecimal Latitud;
        private BigDecimal Longitud;

        public Posicion(BigDecimal latitud, BigDecimal longitud) {
            Latitud = latitud;
            Longitud = longitud;
        }

        public BigDecimal getLatitud() {
            return Latitud;
        }

        public BigDecimal getLongitud() {
            return Longitud;
        }
    }

    public class Haversine {
        public static final BigDecimal RADIO_TIERRA_KM = new BigDecimal("6378.0");
        public static final MathContext MATH_CONTEXT = new MathContext(10, RoundingMode.HALF_UP);

        public static BigDecimal distanciaKm(Posicion posOrigen, Posicion posDestino) {
            BigDecimal difLatitud = posDestino.getLatitud().subtract(posOrigen.getLatitud()).multiply(enRadianes());
            BigDecimal difLongitud = posDestino.getLongitud().subtract(posOrigen.getLongitud()).multiply(enRadianes());

            BigDecimal a = new BigDecimal(Math.sin(difLatitud.doubleValue() / 2), MATH_CONTEXT).pow(2);
            BigDecimal cosLat1 = new BigDecimal(Math.cos(posOrigen.getLatitud().doubleValue()), MATH_CONTEXT);
            BigDecimal cosLat2 = new BigDecimal(Math.cos(posDestino.getLatitud().doubleValue()), MATH_CONTEXT);
            BigDecimal sinDifLongitud = new BigDecimal(Math.sin(difLongitud.doubleValue() / 2), MATH_CONTEXT).pow(2);

            BigDecimal aSum = a.add(cosLat1.multiply(cosLat2).multiply(sinDifLongitud));
            BigDecimal c = new BigDecimal(2 * Math.atan2(Math.sqrt(aSum.doubleValue()), Math.sqrt(1 - aSum.doubleValue())), MATH_CONTEXT);

            return RADIO_TIERRA_KM.multiply(c, MATH_CONTEXT);
        }

        public static BigDecimal enRadianes() {
            return new BigDecimal(Math.PI / 180, MATH_CONTEXT);
        }

        public static void main(String[] args) {
            Posicion posOrigen = new Posicion(new BigDecimal("52.5200"), new BigDecimal("13.4050"));
            Posicion posDestino = new Posicion(new BigDecimal("48.8566"), new BigDecimal("2.3522"));

            BigDecimal distancia = distanciaKm(posOrigen, posDestino);
            System.out.println("Distancia: " + distancia + " kilometros");
        }
    }
}
