
package empleado;

import dao.AsistenciaDAO;
import dao.IServicioAsistencia;
import excepciones.NoHayEmpleadoException;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import modelo.GeneradorDeAsistencia;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GeneradorDeAsistenciaTest {
    
    private IServicioAsistencia servicio;
    private List<Empleado> list;
    private GeneradorDeAsistencia generador;
    
    public GeneradorDeAsistenciaTest() {
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
        list = new ArrayList();
        generador = new GeneradorDeAsistencia(list, servicio);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test(expected = NoHayEmpleadoException.class)
    public void SiNoHayEmpleadosCuandoIntenteGenerarAsistenciasDebeDarError() throws 
            NoHayEmpleadoException {
        
        generador.generar();
    }
    
    @Test
    public void dadaUnaListaDeTresEmpleadosSeDebenGenerarTresAsistencias() throws NoHayEmpleadoException {
     
        list.add(new Empleado());
        list.add(new Empleado());
        list.add(new Empleado());
        
        generador.generar();
        
        assertEquals(3, generador.getNumeroDeAsistenciasGeneradas());
    }
    
    @Test
    public void dadaUnaListaDeDiezEmpleadosSeDebenGenerarDiezAsistencias() throws NoHayEmpleadoException {
        
        list.add(new Empleado());
        list.add(new Empleado());
        list.add(new Empleado());
        list.add(new Empleado());
        list.add(new Empleado());
        list.add(new Empleado());
        list.add(new Empleado());
        list.add(new Empleado());
        list.add(new Empleado());
        list.add(new Empleado());
        
        generador.generar();
        
        assertEquals(10, generador.getNumeroDeAsistenciasGeneradas());
    }
}
