package com.mycompany.calculadoracomplejos;

/**
 *
 * @author Sergio
 */
public class VecComple {

    NumComple[] vector;

    public VecComple(NumComple[] vector) {
        this.vector = vector;
    }

    public NumComple[] getVector() {
        return vector;
    }

    public VecComple inverse() {
        VecComple r = new VecComple(new NumComple[vector.length]);
        for (int i = 0; i < vector.length; i++) {
            r.getVector()[i] = CalcuComple.multiplicacion(vector[i], new NumComple(-1, 0));
        }
        return r;
    }

    public VecComple conjugate() {
        VecComple r = new VecComple(new NumComple[vector.length]);
        for (int i = 0; i < vector.length; i++) {
            r.getVector()[i] = vector[i].conjugado();
        }
        return r;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VecComple)) {
            return false;
        }
        VecComple v = (VecComple) o;
        if (v.getVector().length != vector.length) {
            return false;
        }
        boolean b = false;
        for (int i = 0; i < v.getVector().length; i++) {
            if (!v.getVector()[i].equals(vector[i])) {
                b = false;
                break;
            } else {
                b = true;
            }
        }
        return b;
    }
}
