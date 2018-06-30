
package empleado;

import excepciones.*;
import dao.IServicioAsistencia;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.junit.*;
import static org.mockito.Mockito.*;
import reportes.ReporteDeAsistencia;

public class ReporteDeAsistenciaTest {
    
    private DateTime fechaDeConsulta;
    private DateTime fechaActual; 
    private ReporteDeAsistencia asistencias;
    private IServicioAsistencia servicio;
    
    public ReporteDeAsistenciaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        servicio = mock(IServicioAsistencia.class);
        fechaDeConsulta = new DateTime("2017-12-12");
        fechaActual = new DateTime("2017-12-12");
       
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = FechaIncorrectaException.class)
    public void noSePuedeConsultarUnReporteDeAsistenciaConLaFechaActual() throws 
           FechaIncorrectaException, SinFechasException {
         
        asistencias = new ReporteDeAsistencia(fechaDeConsulta.toDate(), 
                fechaActual.toDate());
        asistencias.generar();
    }
    
    @Test(expected = FechaIncorrectaException.class)
    public void laFechaDeConsultaNoPuedeSerPosteriorALaActual() throws 
            FechaIncorrectaException, SinFechasException {
        
        fechaDeConsulta = new DateTime("2017-12-13");
     
        asistencias = new ReporteDeAsistencia(fechaDeConsulta.toDate(), 
                fechaActual.toDate());
        
        asistencias.generar();
    }
    
    @Test(expected = SinFechasException.class)
    public void fechaDeConsultaVacia() throws SinFechasException, 
            FechaIncorrectaException {
        
        asistencias = new ReporteDeAsistencia(null, 
                fechaActual.toDate());
        asistencias.generar();
    }
    
    @Test(expected = FechaIncorrectaException.class)
    public void noHuboActividadParaLaFechaDeConsulta() throws 
            FechaIncorrectaException, SinFechasException {
        
        fechaActual = new DateTime("2017-12-15");
        fechaDeConsulta = new DateTime("2017-12-14");
        
        when(servicio.asistenciasDelDia(fechaDeConsulta))
                .thenReturn(new ArrayList<>());
        
        asistencias = new ReporteDeAsistencia(fechaDeConsulta.toDate(), 
                fechaActual.toDate());
        asistencias.setServicio(servicio);
        asistencias.generar();
        
    }
}
