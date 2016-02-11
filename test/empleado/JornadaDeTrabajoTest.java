
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
    private NullJornada nullJornada;
    private JornadaDAO jornadaDao;
    private IServicioAsistencia servicio;
    private List<Empleado> empleados;
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
        nullJornada = new NullJornada();
        jornadaDao = mock(JornadaDAO.class);
        servicio = mock(AsistenciaDAO.class);
        empleados = new ArrayList<>();
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
    
    @Test(expected = NoHayEmpleadoException.class)
    public void noSePuedeIniciarLaJornadaPorQueAunNoHayEmpleadosRegistrados() throws 
            NoHayEmpleadoException, JornadaEnCursoException, JornadaCerradaException{
        jornada = new JornadaDeTrabajo(empleados, servicio);
        jornada.iniciar();
    }
    
    
    @Test(expected = JornadaEnCursoException.class)
    public void yaHayUnaJornadaEnCurso() throws JornadaEnCursoException, 
            NoHayEmpleadoException,
            JornadaCerradaException {
        empleados.add(new Empleado());
        jornada = new JornadaDeTrabajo(empleados, servicio);
        jornada.iniciar();
        jornada.iniciar();
    }
    
    @Test(expected = JornadaCerradaException.class)
    public void NoPuedeIniciarMasJornada_YaFueCerradaLaJornadaEnCurso() throws JornadaEnCursoException, 
            NoHayEmpleadoException,
            JornadaCerradaException {
        empleados.add(new Empleado());
        jornada = new JornadaDeTrabajo(empleados, servicio);
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
        
        jornada = new JornadaDeTrabajo(servicio);
        jornada.cerrar();  
    }
}
