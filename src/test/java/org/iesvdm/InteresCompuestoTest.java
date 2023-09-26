package org.iesvdm;

import org.iesvdm.InteresCompuesto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InteresCompuestoTest {

    @Test
    public void cuandoPrincipal1000Interes5porcientoY10peridos() {

        String principal = "1000";
        int interes = 5;
        int periodos = 10;

        //TODO
        BigDecimal p = new BigDecimal(principal);
        BigDecimal r = new BigDecimal("0.05");
        InteresCompuesto interesCompuesto = new InteresCompuesto(p, r, 1);
        BigDecimal cantidadFinal = interesCompuesto.calculaMontoFinal(periodos);

        BigDecimal cantidadEsperada = new BigDecimal("1628.89");

        Assertions.assertEquals(new BigDecimal("1628.89"), cantidadFinal);
    }

}
