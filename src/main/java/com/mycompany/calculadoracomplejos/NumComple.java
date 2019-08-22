package com.mycompany.calculadoracomplejos;

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
    
    @Override
    public int hashCode(){
        int hash=3;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.pReal) ^ (Double.doubleToLongBits(this.pReal) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.pImg) ^ (Double.doubleToLongBits(this.pImg) >>> 32));
        return hash;
    }
    
    private double round(double d) {
        String s = Double.toString(d);
        if (s.length() > 7) {
            s = s.substring(0, 7);
        }
        return Double.valueOf(s);
    }
}
