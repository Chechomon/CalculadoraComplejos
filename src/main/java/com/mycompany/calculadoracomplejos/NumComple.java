package com.mycompany.calculadoracomplejos;

import java.text.DecimalFormat;

/**
 *
 * @author Sergio
 */
public class NumComple {

    double pReal;
    double pImg;

    public NumComple(double pReal, double pImg) {
        this.pReal = pReal;
        this.pImg = pImg;
    }

    public double getpReal() {
        return pReal;
    }

    public double getpImg() {
        return pImg;
    }

    public String getComplexNumber() {
        DecimalFormat df = new DecimalFormat("#.##");
        if (pImg < 0) {
            return df.format(pReal) + " - " + df.format(pImg * -1) + "i";
        } else {
            return df.format(pReal) + " + " + df.format(pImg) + "i";
        }
    }

    public double modulo() {
        return Math.sqrt(Math.pow(pReal, 2) + Math.pow(pImg, 2));
    }

    public NumComple conjugado() {
        return new NumComple(pReal, pImg * -1);
    }
    
    public double getFase() {
        return Math.atan2(pImg, pReal);
    }

}
