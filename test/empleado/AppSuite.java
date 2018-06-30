
package empleado;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({empleado.LoginTest.class, 
    empleado.ReporteDeInasistenciasTest.class, 
    empleado.AnalizadorDeJornadaTest.class, 
    empleado.ReporteDeAsistenciaTest.class, 
    empleado.JornadaDeTrabajoTest.class, 
    empleado.PermisoTest.class, 
    empleado.AsistenciaTest.class, 
    empleado.InasistenciaTest.class, 
    empleado.CedulaTest.class, empleado.ReporteDeInasistenciaDiariaTest.class,
    empleado.GeneradorDeAsistenciaTest.class, empleado.EmpleadoTest.class})
public class AppSuite {

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
