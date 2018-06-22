
package empleado;

import excepciones.*;
import modelo.*;
import nullObjects.NullJornada;
import dao.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class JornadaDeTrabajoTest {
    
    private JornadaDeTrabajo jornada;
    private IServicioAsistencia servicio;
    public JornadaDeTrabajoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        servicio = mock(AsistenciaDAO.class);
        jornada = mock(JornadaDeTrabajo.class);
    }
    
    @After
    public void tearDown() {
    
    }
    
    @Test
    public void jornadaSinIniciar() {
        jornada = new JornadaDeTrabajo();
        assertEquals(EstadoDeJornada.SIN_INICIAR.Valor(), jornada.getEstado());
    }
    
    @Test(expected = JornadaEnCursoException.class)
    public void yaHayUnaJornadaEnCurso() throws JornadaEnCursoException, 
            JornadaCerradaException {
       
        jornada = new JornadaDeTrabajo();
        jornada.iniciar();
        jornada.iniciar();
    }
    
    @Test(expected = JornadaCerradaException.class)
    public void NoPuedeIniciarMasJornada_YaFueCerradaLaJornadaEnCurso() throws JornadaEnCursoException, 
            NoHayEmpleadoException,
            JornadaCerradaException {
       
        jornada = new JornadaDeTrabajo();
        jornada.setEstado(EstadoDeJornada.CERRADA.Valor());
        jornada.iniciar();
    }
    
    @Test
    public void jornadaIniciadaYFinalizadaConExito() throws JornadaEnCursoException, 
            NoHayEmpleadoException,
            AsistenciaIncompletaException {
        when(jornada.getEstado()).thenReturn(EstadoDeJornada.CERRADA.Valor());
        jornada.cerrar();
        assertEquals(EstadoDeJornada.CERRADA.Valor(), jornada.getEstado());
    }
    
    @Test(expected = AsistenciaIncompletaException.class)
    public void NoSePuedeCerrarLaJornadaPorQueFaltanEmpleadosPorMarcarSuSalida() throws 
            AsistenciaIncompletaException, AsistenciaMarcadaException {
        
        Asistencia asistencia = new Asistencia();
        asistencia.marcarEntrada();
        List<Asistencia> asistencias = new ArrayList<>();
        asistencias.add(asistencia);
        
        when(servicio.asistenciasDeHoy()).thenReturn(asistencias);
        
        jornada = new JornadaDeTrabajo();
        jornada.setServicio(servicio);
        jornada.cerrar();  
    }
}
