
package empleado;

import excepciones.SinDepartamentoAsignadoException;
import modelo.Empleado;
import nullObjects.NullDepartamento;
import org.junit.*;
import static org.junit.Assert.*;

public class EmpleadoTest {
    
    public EmpleadoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = SinDepartamentoAsignadoException.class)
    public void debeAsignarAlEmpleadoEnUnDepartamento() throws SinDepartamentoAsignadoException {
        Empleado empleado = new Empleado("22387256", "Engel", "Pinto", 
                new NullDepartamento());
    }
}
