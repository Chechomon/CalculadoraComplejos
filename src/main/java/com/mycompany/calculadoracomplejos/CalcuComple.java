package com.mycompany.calculadoracomplejos;

import java.text.DecimalFormat;

/**
 *
 * @author Sergio
 */
public class CalcuComple {
    
    public static NumComple suma(NumComple c1, NumComple c2) {
        return new NumComple(c1.getpReal() + c2.getpReal(), c1.getpImg() + c2.getpImg());
    }
    
    public static NumComple resta(NumComple c1, NumComple c2) {
        return new NumComple(c1.getpReal() - c2.getpReal(), c1.getpImg() - c2.getpImg());
    }
    
    public static NumComple multiplicacion(NumComple c1, NumComple c2) {
        double pReal = (c1.getpReal() * c2.getpReal()) - (c1.getpImg() * c2.getpImg());
        double pImg = (c1.getpReal() * c2.getpImg()) + (c2.getpReal() * c1.getpImg());
        return new NumComple(pReal, pImg);
    }
    
    public static NumComple division(NumComple c1, NumComple c2) {
        double realNumerador = (c1.getpReal() * c2.getpReal()) + (c1.getpImg() * c2.getpImg());
        double imgNumerador = (c2.getpReal() * c1.getpImg()) - (c1.getpReal() * c2.getpImg());
        double denominador = Math.pow(c2.getpReal(), 2) + Math.pow(c2.getpImg(), 2);
        return new NumComple(Math.round((realNumerador / denominador) * 100.0) / 100.0, Math.round((imgNumerador / denominador) * 100.0) / 100.0);
    }
    
    public static String cartesianaAPolar(NumComple c1) {
        double p = Math.sqrt(Math.pow(c1.getpReal(), 2) + Math.pow(c1.getpImg(), 2));
        double t = Math.atan2(c1.getpImg(), c1.getpReal());
        DecimalFormat df = new DecimalFormat("#.##");
        return "(" + df.format(p) + ", " + df.format(t) + ")";
    }
    
    public static NumComple polarACartesiana(double p, double t) {
        double a = p * Math.cos(t);
        double b = p * Math.sin(t);
        return new NumComple(Math.round(a * 100.0) / 100.0, Math.round(b * 100.0) / 100.0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
