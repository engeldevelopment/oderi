
package empleado;

import reportes.ReporteDeInasistenciaSemanal;
import excepciones.SinInasistenciasException;
import dao.InasistenciaDAO;
import excepciones.FechaDeInicioIncorrecta;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import modelo.Inasistencia;
import modelo.MotivoDeInasistencia;
import org.joda.time.DateTime;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReporteDeInasistenciasTest {
    
    private ReporteDeInasistenciaSemanal reporte;
    private DateTime diaDeSolicitud;
    private DateTime viernes;
    private InasistenciaDAO servicio;
    
    public ReporteDeInasistenciasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        servicio = mock(InasistenciaDAO.class);
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = FechaDeInicioIncorrecta.class)
    public void laFechaDeInicioDebeSerUnDiaLunes() throws FechaDeInicioIncorrecta, 
            SinInasistenciasException {
        
        diaDeSolicitud = new DateTime("2018-04-03");
        reporte = new ReporteDeInasistenciaSemanal(diaDeSolicitud);
        
        reporte.generar();
    }
    
    //@Test
    public void laFechaDeInicioEsUnDiaLunes() throws FechaDeInicioIncorrecta, 
            SinInasistenciasException {
        
        diaDeSolicitud = new DateTime("2018-04-02");
        viernes = new DateTime("2018-04-06");
        reporte = new ReporteDeInasistenciaSemanal(diaDeSolicitud);
        
        reporte.generar();
        
        assertEquals(viernes, reporte.getFechaDeCorte());
    }
    
    //@Test
    public void laFechaDeInicioEsUnDiaLunesYTerminaUnViernes() throws FechaDeInicioIncorrecta, 
            SinInasistenciasException {
        
        diaDeSolicitud = new DateTime("2018-04-30");
        viernes = new DateTime("2018-05-04");
        reporte = new ReporteDeInasistenciaSemanal(diaDeSolicitud);
        
        reporte.generar();
        
        assertEquals(viernes, reporte.getFechaDeCorte());
    }
    
    @Test
    public void inasistenciaDelDiaMartes() throws FechaDeInicioIncorrecta, 
            SinInasistenciasException {
        diaDeSolicitud = new DateTime("2018-04-30");
        List<Inasistencia> lista = new ArrayList();
        Inasistencia martes = new Inasistencia(new Empleado(), new DateTime("2018-05-02"), 
                new Time(12, 0, 0), new MotivoDeInasistencia());
        
        lista.add(martes);
        reporte = new ReporteDeInasistenciaSemanal(diaDeSolicitud);
        reporte.setServicio(servicio);
        
        when(servicio.inasistenciasDurante(diaDeSolicitud, diaDeSolicitud)).thenReturn(lista);
        
        reporte.generar();
        
        verify(servicio);
        
    }
}
