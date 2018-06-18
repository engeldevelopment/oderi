
package empleado;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({empleado.ReporteDeInasistenciasTest.class, 
    empleado.AnalizadorDeJornadaTest.class, 
    empleado.JornadaDeTrabajoTest.class, 
    empleado.PermisoTest.class, 
    empleado.AsistenciaTest.class, empleado.InasistenciaTest.class,
    empleado.LoginTest.class,
    empleado.ReporteDeAsistenciaTest.class, empleado.ReporteTest.class})
public class SuiteDeRelacionDeAsistencia {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
