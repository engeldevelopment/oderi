
package empleado;

import dao.*;
import excepciones.*;
import java.util.ArrayList;
import modelo.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import reportes.ReporteDeInasistenciaDiaria;

public class ReporteDeInasistenciaDiariaTest {
    private Jornada jornada;
    private IServicioInasistencia servicio;
    private ReporteDeInasistenciaDiaria reporte;
    
    public ReporteDeInasistenciaDiariaTest() {
    
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jornada = mock(JornadaDeTrabajo.class);
        servicio = mock(InasistenciaDAO.class);
        reporte = new ReporteDeInasistenciaDiaria(servicio, jornada);
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = SinIniciarJornadaException.class)
   public void noSePuedeVerElReporteSinUnaJornadaIniciadaYFinalizada() throws  
           SinIniciarJornadaException, JornadaEnCursoException, SinInasistenciasException {
       
       when(jornada.estaSinIniciar()).thenReturn(true);
       
       reporte.generar();
   }
   
   @Test(expected = JornadaEnCursoException.class)
   public void noSePuedeVerElReportePorqueHayUnaJornadaEnCurso() throws  
           SinIniciarJornadaException, JornadaEnCursoException, 
           NoHayEmpleadoException, JornadaCerradaException, SinInasistenciasException {
       
       when(jornada.estaEnCurso()).thenReturn(true);
       
       reporte.generar();
   }
   
   @Test(expected = SinInasistenciasException.class)
   public void cuandoNoHayaInasistenciaSeDebeGenerarUnError() throws  
           SinIniciarJornadaException, JornadaEnCursoException, 
           NoHayEmpleadoException, JornadaCerradaException, SinInasistenciasException {
       
       when(servicio.inasistenciasDeHoy()).thenReturn(new ArrayList());
       
       reporte.generar();
   }
}
