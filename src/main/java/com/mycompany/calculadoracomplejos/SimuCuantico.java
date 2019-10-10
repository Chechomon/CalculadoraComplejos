package com.mycompany.calculadoracomplejos;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Sergio
 */
public class SimuCuantico {
    
    public double[] programmingDrill311Y321(double[][]matriz,double[]estadoInicial,int clicks){
        double [] respuesta = new double[estadoInicial.length];
        while(clicks!=0) {
            for (int i = 0; i < estadoInicial.length; i++) {
                double suma = 0;
                for (int j = 0; j < estadoInicial.length; j++) {
                    suma += matriz[i][j] * estadoInicial[j];
                }
                respuesta[i] = suma;
            }
            System.arraycopy(respuesta, 0, estadoInicial, 0, estadoInicial.length);
            clicks-=1;
        }
        return respuesta;
    }
    
    public NumComple[] programmingDrill331(NumComple[][]matriz,NumComple[]estadoInicial,int clicks){
        NumComple[] respuesta = new NumComple[estadoInicial.length];
        while (clicks!=0){
            for (int i = 0; i < estadoInicial.length ; i++) {
                NumComple valor = new NumComple(0,0);
                for (int j = 0; j < estadoInicial.length ; j++) {
                    valor = CalcuComple.suma(valor,CalcuComple.multiplicacion(matriz[i][j],estadoInicial[j]));
                }
                respuesta[i]=valor;
            }
            System.arraycopy(respuesta, 0, estadoInicial, 0, estadoInicial.length);
            clicks-=1;

        }
        return respuesta;
    }
    
    public static ArrayList<Object> programmingDrill322Y332(int slits, int targets, Map p){
        MatComple matriz = crearMatriz(slits+targets+1, slits+targets+1);
        for(int i = 0; i < slits+targets+1; i++) {
            for(int j = 0; j < slits+targets+1; j++) {
                if(p.containsKey(Integer.toString(i) + " " + Integer.toString(j))) {
                    matriz.getMatrix()[j][i] = (NumComple) p.get(Integer.toString(i) + " " + Integer.toString(j));
                } else {
                    matriz.getMatrix()[j][i] = new NumComple(0,0);
                }
            }
        }
        for (int i = 0; i < slits+1; i++) {
            matriz.getMatrix()[i][i] = new NumComple(0,0);
        }
        for (int i = slits + 1; i < slits+targets+1;i++) {
            matriz.getMatrix()[i][i] = new NumComple(1,0);
        }
        VecComple vector = new VecComple(new NumComple[slits+targets+1]);
        vector.getVector()[0] = new NumComple(1, 0);
        for (int i = 1; i < vector.getVector().length;i++) {
            vector.getVector()[i] = new NumComple(0,0);
        }
        ArrayList<Object> r = new ArrayList<Object>();
        r.add(mutiplicacionMatrices(matriz,matriz));
        r.add(accionMatrizSobreVector(mutiplicacionMatrices(matriz,matriz), vector));
        return r;
    }

    private static VecComple accionMatrizSobreVector(MatComple matriz, VecComple vector){
        VecComple r = new VecComple(new NumComple[vector.getVector().length]);
        NumComple s = new NumComple(0,0);
        for (int i = 0; i < vector.getVector().length; i++) {
            for (int j = 0; j < matriz.getMatrix()[0].length; j++) {
                s = CalcuComple.suma(s, CalcuComple.multiplicacion(matriz.getMatrix()[i][j], vector.getVector()[j]));
            }
            r.getVector()[i] = s;
            s = new NumComple(0,0);
        }
        return r;
    }

    private static MatComple mutiplicacionMatrices(MatComple m1, MatComple m2){
        MatComple r = crearMatriz(m1.getMatrix().length, m1.getMatrix()[0].length);
        NumComple s = new NumComple(0,0);
        for (int m = 0; m < m1.getMatrix().length; m++) {
            for (int n = 0; n < m1.getMatrix()[0].length; n++) {
                for (int i = 0; i < m1.getMatrix().length; i++) {
                    s = CalcuComple.suma(s, CalcuComple.multiplicacion(m1.getMatrix()[m][i], m2.getMatrix()[i][n]));
                }
                r.getMatrix()[m][n] = s;
                s = new NumComple(0,0);
            }
        }
        return r;
    }

    private static MatComple crearMatriz(int i, int j) {
        MatComple r =null;
        try {
            r = new MatComple(new NumComple[i][j]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public static double probabilidad(VecComple estado, int posicion) {
        Double n = 0.0;
        for(int i = 0; i < estado.getVector().length;i++) {
            n += Math.pow(estado.getVector()[i].modulo(), 2);
        }
        Double norm = Math.sqrt(n);
        Double prob = Math.pow(estado.getVector()[posicion].modulo(),2) / Math.pow(norm, 2);
        return prob;
    }

    public static NumComple transicion(VecComple estadoInicial, VecComple estadoFinal){
        VecComple bra = estadoFinal.conjugado();
        NumComple ans = productoInterno(estadoFinal, estadoInicial);
        return ans;
    }

    public static NumComple productoInterno(VecComple v1, VecComple v2){
        NumComple r = new NumComple(0,0);
        for (int i = 0; i < v1.getVector().length;i++) {
            r = CalcuComple.suma(r, CalcuComple.multiplicacion(v1.conjugado().getVector()[i], v2.getVector()[i]));
        }
        return r;
    }

    public static NumComple valorMedia(VecComple ket, MatComple observable){
        VecComple omegaKet = accionMatrizSobreVector(observable, ket);
        NumComple ans = productoInterno(omegaKet, ket);
        return ans;
    }

    public static NumComple varianza(VecComple ket, MatComple observable) throws Exception {
        NumComple mean = valorMedia(ket, observable);
        MatComple m = new MatComple(new NumComple[2][2]);
        m.getMatrix()[0][0] = mean;
        m.getMatrix()[0][1] = new NumComple(0, 0);
        m.getMatrix()[1][0] = new NumComple(0, 0);
        m.getMatrix()[1][1] = mean;
        MatComple subtraction = adicionDeMatrices(observable, m.inverse());
        MatComple temp = matrizMultiplicacion(subtraction, subtraction);
        VecComple act = accionMatrizSobreVector(temp, ket);
        NumComple ans = productoInterno(ket, act);
        return ans;

    }

    private static MatComple matrizMultiplicacion(MatComple m1, MatComple m2) {
        MatComple r = crearMatriz(m1.getMatrix().length, m1.getMatrix()[0].length);
        NumComple s = new NumComple(0,0);
        for (int m = 0; m < m1.getMatrix().length; m++) {
            for (int n = 0; n < m1.getMatrix()[0].length; n++) {
                for (int i = 0; i < m1.getMatrix().length; i++) {
                    s = CalcuComple.suma(s, CalcuComple.multiplicacion(m1.getMatrix()[m][i], m2.getMatrix()[i][n]));
                }
                r.getMatrix()[m][n] = s;
                s = new NumComple(0,0);
            }
        }
        return r;
    }

    public static MatComple adicionDeMatrices(MatComple m1, MatComple m2) {
        MatComple r = crearMatriz(m1.getMatrix().length, m1.getMatrix()[0].length);
        for (int i = 0; i < m1.getMatrix().length; i++) {
            for (int j = 0 ; j < m1.getMatrix()[0].length; j++) {
                r.getMatrix()[i][j] = CalcuComple.suma(m1.getMatrix()[i][j], m2.getMatrix()[i][j]);
            }
        }
        return r;
    }

    public static VecComple dinamica(MatComple[] m, VecComple estadoInicial){
        VecComple ans = accionMatrizSobreVector(m[0], estadoInicial);
        for (int i = 1; i < m.length; i++) {
            ans = accionMatrizSobreVector(m[1], ans);
        }
        return ans;
    }
}
