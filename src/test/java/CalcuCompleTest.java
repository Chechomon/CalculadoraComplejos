import com.mycompany.calculadoracomplejos.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }
    
    @Test
    public void restaTest() {
        NumComple c1 = new NumComple(5, 7);
        NumComple c2 = new NumComple(3, 1);
        NumComple result = CalcuComple.resta(c1, c2);
        NumComple expected = new NumComple(2, 6);
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }
    
    @Test
    public void multiplicacionTest() {
        NumComple c1 = new NumComple(3, -2);
        NumComple c2 = new NumComple(1, 2);
        NumComple result = CalcuComple.multiplicacion(c1, c2);
        NumComple expected = new NumComple(7, 4);
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }
    
    @Test
    public void divisionTest() {
        NumComple c1 = new NumComple(-2, 1);
        NumComple c2 = new NumComple(1, 2);
        NumComple result = CalcuComple.division(c1, c2);
        NumComple expected = new NumComple(0, 1);
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());;
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
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }
    
    @Test
    public void getPhaseTest() {
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
        assertEquals(expected.getComplexNumber(), result.getComplexNumber());
    }
}
