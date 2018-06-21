
package empleado;

import modelo.*;
import excepciones.*;
import java.sql.Time;
import org.junit.*;
import static org.junit.Assert.*;

public class AsistenciaTest {
    
    private Asistencia asistencia;
    private Empleado empleado;
    
    public AsistenciaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {   
        empleado = new Empleado();
        empleado.setCedula("22387256");
        empleado.setNombre("Engel");
        empleado.setApellido("Pinto");
        asistencia = new Asistencia(empleado, AsistenciaBuild.fechaActual());
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void horaCero() {
      assertEquals("00:00:00", asistencia.getHoraDeEntrada().toString());
      assertEquals("00:00:00", asistencia.getHoraDeSalida().toString());
    }
    
    @Test
    public void asistenciaSinFirmar() {
        asistencia = new Asistencia();
        assertTrue(asistencia.estaSinFirmar());
    }

    
    @Test(expected = AsistenciaMarcadaException.class)
    public void elEmpleadoYaFirmoSuEntrada() throws AsistenciaMarcadaException {
        asistencia.marcarEntrada();
        asistencia.marcarEntrada();
    }
    
    @Test(expected = AsistenciaMarcadaException.class)
    public void elEmpleadoYaFirmoSuSalida() throws 
            AsistenciaMarcadaException, 
            EntradaSinMarcarException {
        
        asistencia.marcarEntrada();
        asistencia.marcarSalida();
        asistencia.marcarSalida();
    }
    
    @Test(expected = EntradaSinMarcarException.class)
    public void marcarSalidaSinMarcarLaEntrada() throws 
            EntradaSinMarcarException, 
            AsistenciaMarcadaException {
        
        asistencia.marcarSalida();
    }
    
    @Test
    public void marcarAsistencia() {
        try {
            asistencia.marcarEntrada();
            
        } catch (AsistenciaMarcadaException ex) {
            fail("No debió lanzar una excepción");
        }
        
        try {
            asistencia.marcarSalida();
            
        } catch (EntradaSinMarcarException | AsistenciaMarcadaException ex) {
            fail("No debió lanzar una excepción");
        }        
    }
    
    @Test
    public void horasTrabajadasDeUnEmpleado() {
        Time horaDeEntrada = new Time(10, 30, 0);
        Time horaDeSalida = new Time(15, 30, 0);
        int horasTrabajadas = 5;
        
        asistencia.setHoraDeEntrada(horaDeEntrada);
        asistencia.setHoraDeSalida(horaDeSalida);
        assertEquals(horasTrabajadas, asistencia.HorasTrabajadas());
    }
}
