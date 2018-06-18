
package empleado;

import excepciones.*;
import reportes.RelacionDeAsistencia;
import dao.InasistenciaDAO;
import modelo.Jornada;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReporteTest {
    
    private Jornada jornada;
    private InasistenciaDAO servicio;
    
    public ReporteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    
    }
    
    @Before
    public void setUp() {
        jornada = mock(Jornada.class);
        servicio = mock(InasistenciaDAO.class);
    }
    
    @After
    public void tearDown() {
    
    }
    
   @Test(expected = SinIniciarJornadaException.class)
   public void noSePuedeVerElReporteSinUnaJornadaIniciadaYFinalizada() throws  
           SinIniciarJornadaException, JornadaEnCursoException {
       
       when(jornada.estaSinIniciar()).thenReturn(true);
       RelacionDeAsistencia relacion = new RelacionDeAsistencia(jornada, servicio);
       relacion.imprimir();
   }
   
   @Test(expected = JornadaEnCursoException.class)
   public void noSePuedeVerElReportePorqueHayUnaJornadaEnCurso() throws  
           SinIniciarJornadaException, JornadaEnCursoException, 
           NoHayEmpleadoException, JornadaCerradaException {
       
       when(jornada.estaEnCurso()).thenReturn(true);
       RelacionDeAsistencia relacion = new RelacionDeAsistencia(jornada);
       relacion.imprimir();
   }
}
