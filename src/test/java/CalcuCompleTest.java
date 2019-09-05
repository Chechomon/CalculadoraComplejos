import com.mycompany.calculadoracomplejos.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergio
 */
public class CalcuCompleTest {
    
    @Test
    public void sumaTest() {
        NumComple c1 = new NumComple(3, -1);
        NumComple c2 = new NumComple(1, 4);
        NumComple result = CalcuComple.suma(c1, c2);
        NumComple expected = new NumComple(4, 3);
        assertEquals(expected, result);
    }
    
    @Test
    public void restaTest() {
        NumComple c1 = new NumComple(5, 7);
        NumComple c2 = new NumComple(3, 1);
        NumComple result = CalcuComple.resta(c1, c2);
        NumComple expected = new NumComple(2, 6);
        assertEquals(expected, result);
    }
    
    @Test
    public void multiplicacionTest() {
        NumComple c1 = new NumComple(3, -2);
        NumComple c2 = new NumComple(1, 2);
        NumComple result = CalcuComple.multiplicacion(c1, c2);
        NumComple expected = new NumComple(7, 4);
        assertEquals(expected, result);
    }
    
    @Test
    public void divisionTest() {
        NumComple c1 = new NumComple(-2, 1);
        NumComple c2 = new NumComple(1, 2);
        NumComple result = CalcuComple.division(c1, c2);
        NumComple expected = new NumComple(0, 1);
        assertEquals(expected, result);
    }
    
    @Test
    public void moduloTest() {
        NumComple c1 = new NumComple(1, -1);
        double expected = Math.sqrt(2);
        double result = c1.modulo();
        assertEquals(expected, result, 0);
    }
    
    @Test
    public void conjugarTest() {
        NumComple c1 = new NumComple(2, 5);
        NumComple expected = new NumComple(2, -5);
        NumComple result = c1.conjugado();
        assertEquals(expected, result);
    }
    
    @Test
    public void getFaseTest() {
        NumComple c1 = new NumComple(1, 1);
        double expected = Math.PI / 4;
        double result = c1.getFase();
        assertEquals(expected, result, 0);
    }
    
    @Test
    public void cartesianToPolarTest() {
        NumComple c1 = new NumComple(1, 1);
        String expected = "(1,41, 0,79)";
        String result = CalcuComple.cartesianaAPolar(c1);
        assertEquals(expected, result);
    }
    
    @Test
    public void polarToCartesianTest() {
        NumComple result = CalcuComple.polarACartesiana(Math.sqrt(2), Math.PI / 4.0);
        NumComple expected = new NumComple(1, 1);
        assertEquals(expected, result);
    }

    @Test
    public void sumaVectoresTest() throws Exception {
        VecComple v1 = new VecComple(new NumComple[]{new NumComple(1, 2), new NumComple(3, 4), new NumComple(5, 6)});
        VecComple v2 = new VecComple(new NumComple[]{new NumComple(7, 8), new NumComple(9, 0), new NumComple(1, 2)});
        VecComple expected = new VecComple(new NumComple[]{new NumComple(8, 10), new NumComple(12, 4), new NumComple(6, 8)});
        VecComple result = CalcuComple.sumaVectores(v1, v2);
        assertEquals(expected, result);
    }

    @Test
    public void multiplicacionEscalarVectorTest() {
        VecComple v = new VecComple(new NumComple[]{new NumComple(1, 2), new NumComple(3, 4), new NumComple(5, 6)});
        NumComple c = new NumComple(7, 8);
        VecComple actual = CalcuComple.multiplicacionEscalarVector(c, v);
        VecComple expected = new VecComple(new NumComple[]{new NumComple(-9, 22), new NumComple(-11, 52), new NumComple(-13, 82)});
        assertEquals(expected, actual);
    }

    @Test
    public void sumaMatricesTest() throws Exception {
        MatComple m1 = new MatComple(new NumComple[2][2]);
        m1.getMatrix()[0][0] = new NumComple(1, 2);
        m1.getMatrix()[0][1] = new NumComple(5, 6);
        m1.getMatrix()[1][0] = new NumComple(3, 4);
        m1.getMatrix()[1][1] = new NumComple(7, 8);
        MatComple m2 = new MatComple(new NumComple[2][2]);
        m2.getMatrix()[0][0] = new NumComple(9, 0);
        m2.getMatrix()[0][1] = new NumComple(3, 4);
        m2.getMatrix()[1][0] = new NumComple(1, 2);
        m2.getMatrix()[1][1] = new NumComple(5, 6);
        MatComple expected = new MatComple(new NumComple[2][2]);
        expected.getMatrix()[0][0] = new NumComple(10, 2);
        expected.getMatrix()[0][1] = new NumComple(8, 10);
        expected.getMatrix()[1][0] = new NumComple(4, 6);
        expected.getMatrix()[1][1] = new NumComple(12, 14);
        MatComple actual = CalcuComple.sumaMatrices(m1, m2);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicacionEscalarMatrizTest() throws Exception {
        NumComple c = new NumComple(9, 2);
        MatComple m = new MatComple(new NumComple[2][2]);
        m.getMatrix()[0][0] = new NumComple(1, 2);
        m.getMatrix()[0][1] = new NumComple(5, 6);
        m.getMatrix()[1][0] = new NumComple(3, 4);
        m.getMatrix()[1][1] = new NumComple(7, 8);
        MatComple expected = new MatComple(new NumComple[2][2]);
        expected.getMatrix()[0][0] = new NumComple(5, 16);
        expected.getMatrix()[0][1] = new NumComple(33, 64);
        expected.getMatrix()[1][0] = new NumComple(19, 42);
        expected.getMatrix()[1][1] = new NumComple(47, 86);
        MatComple actual = CalcuComple.multiplicacionEscalarMatriz(c, m);
        assertEquals(expected, actual);
    }

    @Test
    public void inversaVectorTest() {
        VecComple v = new VecComple(new NumComple[]{new NumComple(1, 2), new NumComple(3, 4), new NumComple(5, 6)});
        VecComple expected = new VecComple(new NumComple[]{new NumComple(-1, -2), new NumComple(-3, -4), new NumComple(-5, -6)});
        VecComple actual = v.inverso();
        assertEquals(expected, actual);
    }

    @Test
    public void inversaMatrizTest() throws Exception {
        MatComple m = new MatComple(new NumComple[2][2]);
        m.getMatrix()[0][0] = new NumComple(1, 2);
        m.getMatrix()[0][1] = new NumComple(5, 6);
        m.getMatrix()[1][0] = new NumComple(3, 4);
        m.getMatrix()[1][1] = new NumComple(7, 8);
        MatComple expected = new MatComple(new NumComple[2][2]);
        expected.getMatrix()[0][0] = new NumComple(-1, -2);
        expected.getMatrix()[0][1] = new NumComple(-5, -6);
        expected.getMatrix()[1][0] = new NumComple(-3, -4);
        expected.getMatrix()[1][1] = new NumComple(-7, -8);
        MatComple actual = m.inverse();
        assertEquals(expected, actual);
    }

    @Test
    public void multiplicacionMatricesTest() throws Exception {
        MatComple m1 = new MatComple(new NumComple[3][3]);
        m1.getMatrix()[0][0] = new NumComple(3, 2);
        m1.getMatrix()[0][1] = new NumComple(0, 0);
        m1.getMatrix()[0][2] = new NumComple(5, -6);
        m1.getMatrix()[1][0] = new NumComple(1, 0);
        m1.getMatrix()[1][1] = new NumComple(4, 2);
        m1.getMatrix()[1][2] = new NumComple(0, 1);
        m1.getMatrix()[2][0] = new NumComple(4, -1);
        m1.getMatrix()[2][1] = new NumComple(0, 0);
        m1.getMatrix()[2][2] = new NumComple(4, 0);
        MatComple m2 = new MatComple(new NumComple[3][3]);
        m2.getMatrix()[0][0] = new NumComple(5, 0);
        m2.getMatrix()[0][1] = new NumComple(2, -1);
        m2.getMatrix()[0][2] = new NumComple(6, -4);
        m2.getMatrix()[1][0] = new NumComple(0, 0);
        m2.getMatrix()[1][1] = new NumComple(4, 5);
        m2.getMatrix()[1][2] = new NumComple(2, 0);
        m2.getMatrix()[2][0] = new NumComple(7, -4);
        m2.getMatrix()[2][1] = new NumComple(2, 7);
        m2.getMatrix()[2][2] = new NumComple(0, 0);
        MatComple expected = new MatComple(new NumComple[3][3]);
        expected.getMatrix()[0][0] = new NumComple(26, -52);
        expected.getMatrix()[0][1] = new NumComple(60, 24);
        expected.getMatrix()[0][2] = new NumComple(26, 0);
        expected.getMatrix()[1][0] = new NumComple(9, 7);
        expected.getMatrix()[1][1] = new NumComple(1, 29);
        expected.getMatrix()[1][2] = new NumComple(14, 0);
        expected.getMatrix()[2][0] = new NumComple(48, -21);
        expected.getMatrix()[2][1] = new NumComple(15, 22);
        expected.getMatrix()[2][2] = new NumComple(20, -22);
        MatComple actual = CalcuComple.multiplicacionMatrices(m1, m2);
        assertEquals(expected, actual);
    }

    @Test
    public void accionMatrizVectorTest() throws Exception {
        MatComple m = new MatComple(new NumComple[3][3]);
        m.getMatrix()[0][0] = new NumComple(3, 2);
        m.getMatrix()[0][1] = new NumComple(0, 0);
        m.getMatrix()[0][2] = new NumComple(5, -6);
        m.getMatrix()[1][0] = new NumComple(1, 0);
        m.getMatrix()[1][1] = new NumComple(4, 2);
        m.getMatrix()[1][2] = new NumComple(0, 1);
        m.getMatrix()[2][0] = new NumComple(4, -1);
        m.getMatrix()[2][1] = new NumComple(0, 0);
        m.getMatrix()[2][2] = new NumComple(4, 0);
        VecComple v = new VecComple(new NumComple[]{new NumComple(7, 8), new NumComple(9, 0), new NumComple(1, 2)});
        VecComple expected = new VecComple(new NumComple[]{new NumComple(22, 42), new NumComple(41, 27), new NumComple(40, 33)});
        VecComple actual = CalcuComple.accionMatrizVector(m, v);
        assertEquals(expected, actual);
    }

    @Test
    public void conjugadoVector() {
        VecComple v = new VecComple(new NumComple[]{new NumComple(5, 6), new NumComple(3, 2), new NumComple(-7, 1)});
        VecComple expected = new VecComple(new NumComple[]{new NumComple(5, -6), new NumComple(3, -2), new NumComple(-7, -1)});
        VecComple actual = v.conjugado();
        assertEquals(expected, actual);
    }

    @Test
    public void transpuestaMatrizTest() throws Exception {
        MatComple m = new MatComple(new NumComple[2][2]);
        m.getMatrix()[0][0] = new NumComple(3, 2);
        m.getMatrix()[0][1] = new NumComple(9, 5);
        m.getMatrix()[1][0] = new NumComple(5, -6);
        m.getMatrix()[1][1] = new NumComple(1, 4);
        MatComple expected = new MatComple(new NumComple[2][2]);
        expected.getMatrix()[0][0] = new NumComple(3, 2);
        expected.getMatrix()[0][1] = new NumComple(5, -6);
        expected.getMatrix()[1][0] = new NumComple(9, 5);
        expected.getMatrix()[1][1] = new NumComple(1, 4);
        MatComple actual = m.transpuesta();
        assertEquals(expected, actual);
    }

    @Test
    public void conjugadaMatrizTest() throws Exception {
        MatComple m = new MatComple(new NumComple[2][2]);
        m.getMatrix()[0][0] = new NumComple(3, 2);
        m.getMatrix()[0][1] = new NumComple(9, 5);
        m.getMatrix()[1][0] = new NumComple(5, -6);
        m.getMatrix()[1][1] = new NumComple(1, 4);
        MatComple expected = new MatComple(new NumComple[2][2]);
        expected.getMatrix()[0][0] = new NumComple(3, -2);
        expected.getMatrix()[0][1] = new NumComple(9, -5);
        expected.getMatrix()[1][0] = new NumComple(5, 6);
        expected.getMatrix()[1][1] = new NumComple(1, -4);
        MatComple actual = m.conjugada();
        assertEquals(expected, actual);
    }

    @Test
    public void adjuntaTest() throws Exception {
        MatComple m = new MatComple(new NumComple[2][2]);
        m.getMatrix()[0][0] = new NumComple(3, 2);
        m.getMatrix()[0][1] = new NumComple(9, 5);
        m.getMatrix()[1][0] = new NumComple(5, -6);
        m.getMatrix()[1][1] = new NumComple(1, 4);
        MatComple expected = new MatComple(new NumComple[2][2]);
        expected.getMatrix()[0][0] = new NumComple(3, -2);
        expected.getMatrix()[0][1] = new NumComple(5, 6);
        expected.getMatrix()[1][0] = new NumComple(9, -5);
        expected.getMatrix()[1][1] = new NumComple(1, -4);
        MatComple actual = m.adjunta();
        assertEquals(expected, actual);
    }

    @Test
    public void isMatrizHermitianaTest() throws Exception {
        MatComple m1 = new MatComple(new NumComple[2][2]);
        m1.getMatrix()[0][0] = new NumComple(3, 2);
        m1.getMatrix()[0][1] = new NumComple(9, 5);
        m1.getMatrix()[1][0] = new NumComple(5, -6);
        m1.getMatrix()[1][1] = new NumComple(1, 4);
        boolean actual = CalcuComple.isMatrizHermitiana(m1);
        boolean expected = false;
        assertEquals(expected, actual);

    }

    @Test
    public void isMatrizUnitariaTest() throws Exception {
        MatComple m = new MatComple(new NumComple[2][2]);
        m.getMatrix()[0][0] = new NumComple(3, 2);
        m.getMatrix()[0][1] = new NumComple(9, 5);
        m.getMatrix()[1][0] = new NumComple(5, -6);
        m.getMatrix()[1][1] = new NumComple(1, 4);
        boolean actual = CalcuComple.isMatrizUnitaria(m);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    public void productoTensorTest() throws Exception {
        MatComple m1 = new MatComple(new NumComple[2][2]);
        m1.getMatrix()[0][0] = new NumComple(3, 2);
        m1.getMatrix()[0][1] = new NumComple(5, -1);
        m1.getMatrix()[1][0] = new NumComple(1, 2);
        m1.getMatrix()[1][1] = new NumComple(6, 0);
        MatComple m2 = new MatComple(new NumComple[3][3]);
        m2.getMatrix()[0][0] = new NumComple(1, 0);
        m2.getMatrix()[0][1] = new NumComple(3, 4);
        m2.getMatrix()[0][2] = new NumComple(5, -7);
        m2.getMatrix()[1][0] = new NumComple(10, 2);
        m2.getMatrix()[1][1] = new NumComple(6, 0);
        m2.getMatrix()[1][2] = new NumComple(2, 5);
        m2.getMatrix()[2][0] = new NumComple(0, 0);
        m2.getMatrix()[2][1] = new NumComple(1, 0);
        m2.getMatrix()[2][2] = new NumComple(2, 9);
        MatComple expected = new MatComple(new NumComple[6][6]);
        expected.getMatrix()[0][0] = new NumComple(3, 2);
        expected.getMatrix()[0][1] = new NumComple(1, 18);
        expected.getMatrix()[0][2] = new NumComple(29, -11);
        expected.getMatrix()[0][3] = new NumComple(5, 1);
        expected.getMatrix()[0][4] = new NumComple(19, 17);
        expected.getMatrix()[0][5] = new NumComple(18, -40);
        expected.getMatrix()[1][0] = new NumComple(26, 26);
        expected.getMatrix()[1][1] = new NumComple(18, 12);
        expected.getMatrix()[1][2] = new NumComple(-4, 19);
        expected.getMatrix()[1][3] = new NumComple(52, 0);
        expected.getMatrix()[1][4] = new NumComple(30, -6);
        expected.getMatrix()[1][5] = new NumComple(15, 23);
        expected.getMatrix()[2][0] = new NumComple(0, 0);
        expected.getMatrix()[2][1] = new NumComple(3, 2);
        expected.getMatrix()[2][2] = new NumComple(-12, 31);
        expected.getMatrix()[2][3] = new NumComple(0, 0);
        expected.getMatrix()[2][4] = new NumComple(5, 1);
        expected.getMatrix()[2][5] = new NumComple(19, 43);
        expected.getMatrix()[3][0] = new NumComple(1, 2);
        expected.getMatrix()[3][1] = new NumComple(-5, 10);
        expected.getMatrix()[3][2] = new NumComple(19, 3);
        expected.getMatrix()[3][3] = new NumComple(6, 0);
        expected.getMatrix()[3][4] = new NumComple(18, 24);
        expected.getMatrix()[3][5] = new NumComple(30, 42);
        expected.getMatrix()[4][0] = new NumComple(6, 22);
        expected.getMatrix()[4][1] = new NumComple(6, 12);
        expected.getMatrix()[4][2] = new NumComple(-8, 9);
        expected.getMatrix()[4][3] = new NumComple(60, 12);
        expected.getMatrix()[4][4] = new NumComple(36, 0);
        expected.getMatrix()[4][5] = new NumComple(12, 30);
        expected.getMatrix()[5][0] = new NumComple(0, 0);
        expected.getMatrix()[5][1] = new NumComple(1, 2);
        expected.getMatrix()[5][2] = new NumComple(-16, 13);
        expected.getMatrix()[5][3] = new NumComple(0, 0);
        expected.getMatrix()[5][4] = new NumComple(6, 0);
        expected.getMatrix()[5][5] = new NumComple(12, 54);
        MatComple actual = CalcuComple.productoTensor(m1, m2);
        assertEquals(expected, actual);
    }

    @Test
    public void normaVectorTest() {
        double[] v = new double[]{3, -6, 2};
        double actual = CalcuComple.normaVector(v);
        double expected = 7;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void distanciaVectoresTest() throws Exception {
        double[] v1 = new double[]{3, 1, 2};
        double[] v2 = new double[]{2, 2, -1};
        double expected = Math.sqrt(11);
        double actual = CalcuComple.distanciaVectores(v1, v2);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void normaMatrizTest() throws Exception {
        double[][] m = new double[2][2];
        m[0][0] = 3;
        m[0][1] = 5;
        m[1][0] = 2;
        m[1][1] = 3;
        double expected = Math.sqrt(47);
        double actual = CalcuComple.normaMatriz(m);
        assertEquals(expected, actual, 0.7);
    }

    @Test
    public void distanciaMatricesTest() throws Exception {
        double[][] m1 = new double[2][2];
        m1[0][0] = 3;
        m1[0][1] = 5;
        m1[1][0] = 2;
        m1[1][1] = 3;
        double[][] m2 = new double[2][2];
        m2[0][0] = 1;
        m2[0][1] = 6;
        m2[1][0] = 2;
        m2[1][1] = 4;
        double expected = 2.45;
        double actual = CalcuComple.distanciaMatrices(m1, m2);
        assertEquals(expected, actual, 0.1);
    }
}
