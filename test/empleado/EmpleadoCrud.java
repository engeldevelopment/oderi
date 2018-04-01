
package empleado;

import modelo.Departamento;
import modelo.Empleado;
import org.junit.*;
import static org.junit.Assert.*;

public class EmpleadoCrud {
    
    public EmpleadoCrud() {
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

    @Test(expected = CampoVacioException.class)
    public void elCampoCedulaSeEncuentraVacio() throws CampoVacioException, 
            CedulaIncorrectaException {
        
        EmpleadoProxy proxy = new EmpleadoProxySave(new Empleado("","engel","pinto", new Departamento()));
        proxy.verificar();
                
    }
    
    @Test(expected = CedulaIncorrectaException.class)
    public void cedulaConMenosDe_6_digitos() throws CedulaIncorrectaException, 
            CampoVacioException {
    
        EmpleadoProxy proxy = new EmpleadoProxySave(new Empleado("2333","engel","pinto", new Departamento()));
        proxy.verificar();
                
    }
    
    @Test(expected = CedulaIncorrectaException.class)
    public void cedulaConMasDe_8_digitos() throws CedulaIncorrectaException, 
            CampoVacioException {
    
        EmpleadoProxy proxy = new EmpleadoProxySave(new Empleado("233322222","engel","pinto", new Departamento()));
        proxy.verificar();
                
    }
}
