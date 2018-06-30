
package empleado;

import excepciones.*;
import modelo.*;
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
        jornada = new JornadaDeTrabajo();
        jornada.setServicio(servicio);
    }
    
    @After
    public void tearDown() {
    
    }
    
    @Test
    public void jornadaSinIniciar() {
        
        assertEquals(EstadoDeJornada.SIN_INICIAR.Valor(), jornada.getEstado());
    }
    
    @Test(expected = JornadaEnCursoException.class)
    public void yaHayUnaJornadaEnCurso() throws JornadaEnCursoException, 
            JornadaCerradaException {
       
        jornada.iniciar();
        jornada.iniciar();
    }
    
    @Test(expected = JornadaCerradaException.class)
    public void NoPuedeIniciarMasJornada_YaFueCerradaLaJornadaEnCurso() throws JornadaEnCursoException, 
            NoHayEmpleadoException,
            JornadaCerradaException {
       
        
        jornada.setEstado(EstadoDeJornada.CERRADA.Valor());
        jornada.iniciar();
    }
    
    
    @Test(expected = AsistenciaIncompletaException.class)
    public void NoSePuedeCerrarLaJornadaPorQueFaltanEmpleadosPorMarcarSuSalida() throws 
            AsistenciaIncompletaException, AsistenciaMarcadaException, 
            JornadaCerradaException, SinIniciarJornadaException, JornadaEnCursoException {
        
        Asistencia asistencia = new Asistencia();
        asistencia.marcarEntrada();
        List<Asistencia> asistencias = new ArrayList<>();
        asistencias.add(asistencia);
        
        when(servicio.asistenciasDeHoy()).thenReturn(asistencias);
        
        jornada.iniciar();
        jornada.cerrar();  
    }
    
    @Test(expected = SinIniciarJornadaException.class)
    public void primeroDebeIniciarseUnaJornada() throws AsistenciaIncompletaException, 
            JornadaCerradaException,
            SinIniciarJornadaException {
        
        jornada.cerrar();
    }
}