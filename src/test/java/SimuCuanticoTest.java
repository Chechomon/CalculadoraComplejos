import com.mycompany.calculadoracomplejos.MatComple;
import com.mycompany.calculadoracomplejos.NumComple;
import com.mycompany.calculadoracomplejos.SimuCuantico;
import com.mycompany.calculadoracomplejos.VecComple;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Sergio
 */
public class SimuCuanticoTest {

    @Test
    public void  drill321Test(){
        SimuCuantico simulator = new SimuCuantico();
        double[][] matrizDoubles = {{0,0,0,0},
                                    {0,0,0,2.3},
                                    {0,2.3,0,0},
                                    {2.3,0,0,0}};
        double[] estadoInicial = {6,2,5,3};
        double[] solucion = simulator.drill311Y321(matrizDoubles, estadoInicial, 2);
        double[] respuesta = {0,31.739999999999995,15.869999999999997,0};
        for(int i=0;i<respuesta.length;i++){
            assertTrue(respuesta[i]==solucion[i]);
        }
    }

    @Test
    public void drill322Y332Test() throws Exception {
        int slits = 2;
        int targets = 5;
        Map<String, NumComple> p = new HashMap<>();
        p.put("0 1", new NumComple(1.0/Math.sqrt(2), 0));
        p.put("0 2", new NumComple(1.0/Math.sqrt(2), 0));
        p.put("1 3", new NumComple(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6)));
        p.put("1 4", new NumComple(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
        p.put("1 5", new NumComple(1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
        p.put("2 5", new NumComple(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6)));
        p.put("2 6", new NumComple(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
        p.put("2 7", new NumComple(1.0/Math.sqrt(6), -1.0/Math.sqrt(6)));
        MatComple expectedMatrix = new MatComple(new NumComple[8][8]);
        expectedMatrix.getMatrix()[0][0] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[0][1] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[0][2] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[0][3] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[0][4] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[0][5] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[0][6] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[0][7] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[1][0] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[1][1] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[1][2] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[1][3] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[1][4] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[1][5] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[1][6] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[1][7] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[2][0] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[2][1] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[2][2] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[2][3] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[2][4] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[2][5] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[2][6] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[2][7] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[3][0] = new NumComple(-1.0/Math.sqrt(12), 1.0/Math.sqrt(12));
        expectedMatrix.getMatrix()[3][1] = new NumComple(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6));
        expectedMatrix.getMatrix()[3][2] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[3][3] = new NumComple(1, 0);
        expectedMatrix.getMatrix()[3][4] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[3][5] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[3][6] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[3][7] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[4][0] = new NumComple(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        expectedMatrix.getMatrix()[4][1] = new NumComple(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
        expectedMatrix.getMatrix()[4][2] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[4][3] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[4][4] = new NumComple(1, 0);
        expectedMatrix.getMatrix()[4][5] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[4][6] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[4][7] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[5][0] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[5][1] = new NumComple(1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
        expectedMatrix.getMatrix()[5][2] = new NumComple(-1.0/Math.sqrt(6), 1.0/Math.sqrt(6));
        expectedMatrix.getMatrix()[5][3] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[5][4] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[5][5] = new NumComple(1, 0);
        expectedMatrix.getMatrix()[5][6] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[5][7] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[6][0] = new NumComple(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        expectedMatrix.getMatrix()[6][1] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[6][2] = new NumComple(-1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
        expectedMatrix.getMatrix()[6][3] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[6][4] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[6][5] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[6][6] = new NumComple(1, 0);
        expectedMatrix.getMatrix()[6][7] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[7][0] = new NumComple(1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        expectedMatrix.getMatrix()[7][1] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[7][2] = new NumComple(1.0/Math.sqrt(6), -1.0/Math.sqrt(6));
        expectedMatrix.getMatrix()[7][3] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[7][4] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[7][5] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[7][6] = new NumComple(0, 0);
        expectedMatrix.getMatrix()[7][7] = new NumComple(1, 0);
        VecComple expectedVector = new VecComple(new NumComple[8]);
        expectedVector.getVector()[0] = new NumComple(0,0);
        expectedVector.getVector()[1] = new NumComple(0,0);
        expectedVector.getVector()[2] = new NumComple(0,0);
        expectedVector.getVector()[3] = new NumComple(-1.0/Math.sqrt(12), 1.0/Math.sqrt(12));
        expectedVector.getVector()[4] = new NumComple(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        expectedVector.getVector()[5] = new NumComple(0,0);
        expectedVector.getVector()[6] = new NumComple(-1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        expectedVector.getVector()[7] = new NumComple(1.0/Math.sqrt(12), -1.0/Math.sqrt(12));
        VecComple actualVector = (VecComple) SimuCuantico.drill322Y332(slits, targets, p).get(1);
        Assert.assertEquals(expectedVector, actualVector);
    }
    
    @Test
    public void  drill311Test(){
        SimuCuantico simulator = new SimuCuantico();
        double[][] matrizBool = {{0,0,0,0},
                                 {0,0,0,1},
                                 {0,1,0,0},
                                 {1,0,0,0}};
        double[] estadoInicial = {6,2,5,3};
        double[] solucion = simulator.drill311Y321(matrizBool, estadoInicial, 2);
        double[] respuesta = {0,6,3,0};
        for(int i=0;i<respuesta.length;i++){
            assertTrue(respuesta[i]==solucion[i]);
        }
    }
    
     @Test
    public void drill331Test(){
        SimuCuantico simulator = new SimuCuantico();
        NumComple[][] matrizComplejos = new NumComple[3][3];
        matrizComplejos[0][0] = new NumComple(2,4);
        matrizComplejos[0][1] = new NumComple(1,3);
        matrizComplejos[0][2] = new NumComple(5,0);
        matrizComplejos[1][0] = new NumComple(3,2);
        matrizComplejos[1][1] = new NumComple(1,2);
        matrizComplejos[1][2] = new NumComple(7,12);
        matrizComplejos[2][0] = new NumComple(2,2);
        matrizComplejos[2][1] = new NumComple(1,1);
        matrizComplejos[2][2] = new NumComple(2,4);
        NumComple[] estadoInicial = new NumComple[3];
        estadoInicial[0]=new NumComple(1,3);
        estadoInicial[1]=new NumComple(2,5);
        estadoInicial[2]=new NumComple(3,6);
        NumComple[] solucion = simulator.drill331(matrizComplejos,estadoInicial,2);
        NumComple[] respuesta = new NumComple[3];
        respuesta[0]=new NumComple(-701,177);
        respuesta[1]=new NumComple(-1027,84);
        respuesta[2]=new NumComple(-484,100);
        Assert.assertArrayEquals(solucion,respuesta);
    }

    @Test
    public void transicionAmpTest()throws Exception{
        VecComple startState = new VecComple(new NumComple[2]);
        startState.getVector()[0] = new NumComple(Math.sqrt(2) / 2, 0);
        startState.getVector()[1] = new NumComple(0, Math.sqrt(2) / 2);
        VecComple endState = new VecComple(new NumComple[2]);
        endState.getVector()[0] = new NumComple(0,Math.sqrt(2) / 2);
        endState.getVector()[1] = new NumComple(-Math.sqrt(2) / 2, 0);
        NumComple expected = new NumComple(0, -1);
        NumComple actual = SimuCuantico.transicionAmp(startState, endState);
        assertEquals(expected, actual);
    }
    
    @Test
    public void valorMediaTest() throws Exception {
        VecComple ket = new VecComple(new NumComple[2]);
        ket.getVector()[0] = new NumComple(Math.sqrt(2) / 2, 0);
        ket.getVector()[1] = new NumComple(0, Math.sqrt(2) / 2);
        MatComple observable = new MatComple(new NumComple[2][2]);
        observable.getMatrix()[0][0] = new NumComple(1, 0);
        observable.getMatrix()[0][1] = new NumComple(0, -1);
        observable.getMatrix()[1][0] = new NumComple(0, 1);
        observable.getMatrix()[1][1] = new NumComple(2, 0);
        NumComple expected = new NumComple(2.5, 0);
        NumComple actual = SimuCuantico.valorMedia(ket, observable);
        assertEquals(expected, actual);
    }
    
    @Test
    public void probabilidadTest() {
        VecComple state = new VecComple(new NumComple[4]);
        state.getVector()[0] = new NumComple(-3,-1);
        state.getVector()[1] = new NumComple(0,-2);
        state.getVector()[2] = new NumComple(0,1);
        state.getVector()[3] = new NumComple(2,0);
        int position = 2;
        Double expected = 0.052624;
        Double actual = SimuCuantico.probabilidad(state, position);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void varianzaTest() throws Exception {
        VecComple ket = new VecComple(new NumComple[2]);
        ket.getVector()[0] = new NumComple(Math.sqrt(2) / 2, 0);
        ket.getVector()[1] = new NumComple(0, Math.sqrt(2) / 2);
        MatComple observable = new MatComple(new NumComple[2][2]);
        observable.getMatrix()[0][0] = new NumComple(1, 0);
        observable.getMatrix()[0][1] = new NumComple(0, -1);
        observable.getMatrix()[1][0] = new NumComple(0, 1);
        observable.getMatrix()[1][1] = new NumComple(2, 0);
        NumComple expected = new NumComple(0.25, 0);
        NumComple actual = SimuCuantico.varianza(ket, observable);
        assertEquals(expected, actual);
    }
    
    
}

