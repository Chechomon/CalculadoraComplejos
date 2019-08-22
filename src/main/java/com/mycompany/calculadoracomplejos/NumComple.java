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
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof NumComple)) {
            return false;
        }
        NumComple c = (NumComple) o;
        return Double.compare(round(pReal), round(c.getpReal())) == 0 && Double.compare(round(pImg), round(c.getpImg())) == 0;
    }

    private double round(double d) {
        String s = Double.toString(d);
        if (s.length() > 7) {
            s = s.substring(0, 7);
        }
        return Double.valueOf(s);
    }
}
