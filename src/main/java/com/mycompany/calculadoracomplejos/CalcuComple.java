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
    
    public static VecComple sumaVectores(VecComple v1, VecComple v2) throws Exception {
        if (v1.getVector().length != v2.getVector().length) {
            throw new Exception("La longitud de los vectores no es la misma");
        } else {
            VecComple r = new VecComple(new NumComple[v1.getVector().length]);
            for (int i = 0; i < v1.getVector().length; i++) {
                r.getVector()[i] = CalcuComple.suma(v1.getVector()[i], v2.getVector()[i]);
            }
            return r;
        }        
    }
    
    public static VecComple multiplicacionEscalarVector(NumComple c, VecComple v) {
        VecComple r = new VecComple(new NumComple[v.getVector().length]);
        for (int i = 0; i < v.getVector().length; i++) {
            r.getVector()[i] = CalcuComple.multiplicacion(c, v.getVector()[i]);
        }
        return r;
    }
    
    private static MatComple creacionMatriz(int i, int j) {
        MatComple r = null;
        try {
            r = new MatComple(new NumComple[i][j]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
    
    public static MatComple sumaMatrices(MatComple m1, MatComple m2) throws Exception {
        if (m1.getMatrix().length != m2.getMatrix().length || m1.getMatrix()[0].length != m2.getMatrix().length) {
            throw new Exception("Las matrices deben ser del mismo tamaño");
        } else {
            MatComple r = creacionMatriz(m1.getMatrix().length, m1.getMatrix()[0].length);
            for (int i = 0; i < m1.getMatrix().length; i++) {
                for (int j = 0; j < m1.getMatrix()[0].length; j++) {
                    r.getMatrix()[i][j] = suma(m1.getMatrix()[i][j], m2.getMatrix()[i][j]);
                }
            }
            return r;
        }
    }
    
    public static MatComple multiplicacionEscalarMatriz(NumComple c, MatComple m) {
        MatComple r = creacionMatriz(m.getMatrix().length, m.getMatrix()[0].length);
        for (int i = 0; i < m.getMatrix().length; i++) {
            for (int j = 0; j < m.getMatrix()[0].length; j++) {
                r.getMatrix()[i][j] = multiplicacion(c, m.getMatrix()[i][j]);
            }
        }
        return r;
    }
    
    public static MatComple multiplicacionMatrices(MatComple m1, MatComple m2) throws Exception {
        if (m1.getMatrix().length != m2.getMatrix()[0].length) {
            throw new Exception("Las matrices no son cuadradas");
        } else {
            MatComple r = creacionMatriz(m1.getMatrix().length, m1.getMatrix()[0].length);
            NumComple s = new NumComple(0, 0);
            for (int m = 0; m < m1.getMatrix().length; m++) {
                for (int n = 0; n < m1.getMatrix()[0].length; n++) {
                    for (int i = 0; i < m1.getMatrix().length; i++) {
                        s = suma(s, multiplicacion(m1.getMatrix()[m][i], m2.getMatrix()[i][n]));
                    }
                    r.getMatrix()[m][n] = s;
                    s = new NumComple(0, 0);
                }
            }
            return r;
        }
    }
    
    public static VecComple accionMatrizVector(MatComple m, VecComple v) throws Exception {
        if (m.getMatrix()[0].length != v.getVector().length) {
            throw new Exception("La longitud de las filas de la matriz es diferente a la longitud del vector");
        } else {
            VecComple r = new VecComple(new NumComple[v.getVector().length]);
            NumComple s = new NumComple(0, 0);
            for (int i = 0; i < v.getVector().length; i++) {
                for (int j = 0; j < m.getMatrix()[0].length; j++) {
                    s = suma(s, multiplicacion(m.getMatrix()[i][j], v.getVector()[j]));
                }
                r.getVector()[i] = s;
                s = new NumComple(0, 0);
            }
            return r;
        }
    }
    
    public static double normaVector(double[] v) {
        double v2 = 0;
        for (int i = 0; i < v.length; i++) {
            v2 = v2 + v[i] * v[i];
        }
        double r = Math.sqrt(v2);
        return r;
    }
    
    public static double normaMatriz(double[][] m) throws Exception {
        if (m.length != m[0].length) {
            throw new Exception("La matriz no es cuadrada");
        } else {
            double[][] mt = new double[m.length][m[0].length];
            for (int i = 0; i < mt.length; i++) {
                for (int j = 0; j < mt.length; j++) {
                    mt[i][j] = m[j][i];
                }
            }
            double[][] r = new double[m.length][m[0].length];
            double s = 0;
            for (int i = 0; i < mt.length; i++) {
                for (int j = 0; j < mt[0].length; j++) {
                    for (int k = 0; k < mt.length; k++) {
                        s = s + (mt[i][k] * m[i][j]);
                    }
                    r[i][j] = s;
                    s = 0;
                }
            }
            double trace = 0;
            for (int i = 0; i < r.length; i++) {
                trace = trace + r[i][i];
            }
            return Math.sqrt(trace);
        }
    }
    
    public static double distanciaVectores(double[] v1, double[] v2) throws Exception {
        if (v1.length != v2.length) {
            throw new Exception("El vector tiene diferente tamaño");
        } else {
            double s = 0;
            for (int i = 0; i < v1.length; i++) {
                s = s + ((v1[i] - v2[i]) * (v1[i] - v2[i]));
            }
            double r = Math.sqrt(s);
            return r;
        }
    }

    public static double distanciaMatrices(double[][] m1, double[][] m2) throws Exception {
        if (m1.length != m1[0].length) {
            throw new Exception("La matriz no es cuadrada");
        } else {
            double ms[][] = new double[m1.length][m1[0].length];
            for (int i = 0; i < ms.length; i++) {
                for (int j = 0; j < ms[0].length; j++) {
                    ms[i][j] = m1[i][j] - m2[i][j];
                }
            }
            double[][] mt = new double[ms.length][ms[0].length];
            for (int i = 0; i < mt.length; i++) {
                for (int j = 0; j < mt.length; j++) {
                    mt[i][j] = ms[j][i];
                }
            }
            double[][] r = new double[mt.length][mt[0].length];
            double s = 0;
            for (int i = 0; i < mt.length; i++) {
                for (int j = 0; j < mt[0].length; j++) {
                    for (int k = 0; k < mt.length; k++) {
                        s = s + (mt[i][k] * ms[i][j]);
                    }
                    r[i][j] = s;
                    s = 0;
                }
            }
            double trace = 0;
            for (int i = 0; i < r.length; i++) {
                trace = trace + r[i][i];
            }
            return Math.sqrt(trace);
        }
    }
    
    public static boolean isMatrizUnitaria(MatComple m) throws Exception {
        if (m.getMatrix().length != m.getMatrix()[0].length) {
            throw new Exception("La matriz no es cuadrada");
        } else {
            return multiplicacionMatrices(m, m.adjunta()).equals(multiplicacionMatrices(m.adjunta(), m));
        }
    }
    
    public static boolean isMatrizHermitiana(MatComple m) throws Exception {
        if (m.getMatrix().length != m.getMatrix()[0].length) {
            throw new Exception("La matriz no es cuadrada");
        } else {
            return m.equals(m.adjunta());
        }
    }
    
    public static MatComple productoTensor(MatComple m1, MatComple m2) {
        MatComple r = creacionMatriz(m1.getMatrix().length * m2.getMatrix().length, m1.getMatrix()[0].length * m2.getMatrix()[0].length);
        MatComple sp;
        int m = 0;
        int n = 0;
        for (int i = 0; i < m1.getMatrix().length; i++) {
            for (int j = 0; j < m1.getMatrix()[0].length; j++) {
                sp = multiplicacionEscalarMatriz(m1.getMatrix()[i][j], m2);
                for (int k = 0; k < sp.getMatrix().length; k++) {
                    for (int l = 0; l < sp.getMatrix()[0].length; l++) {
                        r.getMatrix()[m][n] = sp.getMatrix()[k][l];
                        n++;
                    }
                    m++;
                    n = j * m2.getMatrix()[0].length;
                }
                m = i * m2.getMatrix().length;
                n = (j + 1) * m2.getMatrix()[0].length;
            }
            m = (i + 1) * m2.getMatrix().length;
            n = 0;
        }
        return r;
    }
    
}
