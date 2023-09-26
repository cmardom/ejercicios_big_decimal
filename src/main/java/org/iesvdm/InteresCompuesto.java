package org.iesvdm;

import java.math.BigDecimal;

public class InteresCompuesto {
//PRUEBA
    private BigDecimal p;
    private BigDecimal r;
    private int n;
    private BigDecimal c;

    public InteresCompuesto(BigDecimal p, BigDecimal r, int n) {
        this.p = p;
        this.r = r;
        this.n = n;
    }

    public BigDecimal getP() {
        return p;
    }

    public void setP(BigDecimal p) {
        this.p = p;
    }

    public BigDecimal getR() {
        return r;
    }

    public void setR(BigDecimal r) {
        this.r = r;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public BigDecimal getC() {
        return c;
    }

    public void setC(BigDecimal c) {
        this.c = c;
    }

    public BigDecimal calculaMontoFinal(int t) {
        //Calcular el monto final después de t años con interés compuesto
        // A = P(1+r/n)^(nt)
        // a. monto total acumulado
        // p. capital inicial
        // r. tasa de interes anual en forma decimal
        // n. numero de veces que se capitaliza el interes por año
        // t. numero de años
        BigDecimal base = r.divide(BigDecimal.valueOf(n), 10, BigDecimal.ROUND_HALF_UP).add(BigDecimal.ONE);
        // el 10 en el metodo divide especifica el número de decimales
        // round half up: redondea al número más proximo y si los dos son equidistantes, al mayor
        //add: añade 1 al resultado de la division

        int exponente = n*t;
        return p.multiply(base.pow(exponente));
    }




}
