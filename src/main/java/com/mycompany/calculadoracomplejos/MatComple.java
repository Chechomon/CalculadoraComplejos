package com.mycompany.calculadoracomplejos;
/**
 *
 * @author Sergio
 */
public class MatComple {

    NumComple[][] matrix;

    public MatComple(NumComple[][] matrix) throws Exception {
        int l = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != l) {
                throw new Exception("The rows of the matrix have to be the same length");
            }
        }
        this.matrix = matrix;
    }

    public NumComple[][] getMatrix() {
        return matrix;
    }

    public MatComple inverse() {
        MatComple r = null;
        try {
            r = new MatComple(new NumComple[matrix.length][matrix[0].length]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                r.getMatrix()[i][j] = CalcuComple.multiplicacion(matrix[i][j], new NumComple(-1, 0));
            }
        }
        return r;
    }

    public MatComple transpuesta() throws Exception {
        if (matrix.length != matrix[0].length) {
            throw new Exception("The matrix is not square");
        } else {
            MatComple r = null;
            try {
                r = new MatComple(new NumComple[matrix.length][matrix.length]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    r.getMatrix()[i][j] = matrix[j][i];
                }
            }
            return r;
        }
    }

    public MatComple conjugada() throws Exception {
        MatComple r = null;
        try {
            r = new MatComple(new NumComple[matrix.length][matrix.length]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                r.getMatrix()[i][j] = matrix[i][j].conjugado();
            }
        }
        return r;
    }

    public MatComple adjunta() throws Exception {
        if (matrix.length != matrix[0].length) {
            throw new Exception("The matrix is not square");
        } else {
            MatComple r = null;
            try {
                r = new MatComple(new NumComple[matrix.length][matrix.length]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            MatComple t = this.transpuesta();
            t = t.conjugada();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    r.getMatrix()[i][j] = t.getMatrix()[i][j];
                }
            }
            return r;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MatComple)) {
            return false;
        }
        MatComple m = (MatComple) o;
        if (m.getMatrix().length != matrix.length || m.getMatrix()[0].length != matrix[0].length) {
            return false;
        }
        boolean b = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!m.getMatrix()[i][j].equals(matrix[i][j])) {
                    b = false;
                    break;
                } else {
                    b = true;
                }
            }
        }
        return b;
    }
    
    @Override
    public int hashCode(){
        int hash=3;
        hash = 57 * hash + (int) (Double.doubleToLongBits(this.matrix.hashCode()) ^ (Double.doubleToLongBits(this.matrix.hashCode()) >>> 32));
        return hash;
    }
}
