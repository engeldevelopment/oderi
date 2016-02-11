
package empleado;

import excepciones.*;
import modelo.*;
import dao.*;
import java.sql.Time;
import org.joda.time.DateTime;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class InasistenciaTest {
    
    private Inasistencia inasistencia;
    private Time horaDeGeneracion;
    private JustificacionDeInasistencia justificacion;
    private DateTime diaActual;
    private DateTime diaGenerada;
    private IServicioInasistencia servicoInasistencia;
    
    public InasistenciaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        inasistencia = new Inasistencia();
        servicoInasistencia = mock(InasistenciaDAO.class);
        horaDeGeneracion = new Time(12, 0, 0);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void inasistenciaSinJustificar() {
        
        assertFalse(inasistencia.estaJustificada());
    }
    
    @Test
    public void justificarInasistencia() {
               
        inasistencia.justificar();
        
        assertTrue(inasistencia.estaJustificada());
    }
    
    @Test(expected = TiempoDeJustificacionCaducadoException.class)
    public void noSePuedeJustificarLaInasistenciaPorQueTranscurrieron24Horas() 
            throws TiempoDeJustificacionCaducadoException, InasistenciaJustificadaException{
        
        diaGenerada = new DateTime("2018-04-10");
        diaActual =  new DateTime("2018-04-12");
        
        
        inasistencia = new Inasistencia(new Empleado(), 
                diaGenerada, 
                horaDeGeneracion, new MotivoDeInasistencia());
        
        justificacion = 
                new JustificacionDeInasistencia(inasistencia, 
                       diaActual, servicoInasistencia);
          
        justificacion.Justificar("");
      
    }
    
    @Test
    public void InasistenciaJustificadaPorqueTienesMenosDe24HorasGenerada() throws 
            TiempoDeJustificacionCaducadoException, InasistenciaJustificadaException {
        
        diaGenerada = new DateTime("2017-11-30");
        diaActual = new DateTime("2017-11-30");
        
        inasistencia = new Inasistencia(new Empleado(), 
                diaGenerada, horaDeGeneracion, new MotivoDeInasistencia());
        
        justificacion = 
                new JustificacionDeInasistencia(inasistencia, 
                        diaActual, servicoInasistencia);
      
          
        justificacion.Justificar("No pudo venir por páro de transporte");
        
        assertTrue(inasistencia.estaJustificada());
    }
    
    @Test(expected = InasistenciaJustificadaException.class)
    public void LaInasistenciaYaFueJustificada() throws InasistenciaJustificadaException, 
            TiempoDeJustificacionCaducadoException {
        
        diaGenerada = new DateTime("2017-11-30");
        diaActual = new DateTime("2017-11-01");
        
        inasistencia = new Inasistencia(new Empleado(), 
                diaGenerada, horaDeGeneracion, new MotivoDeInasistencia());
        
        inasistencia.justificar();
        
        justificacion = 
                new JustificacionDeInasistencia(inasistencia, 
                        diaActual, servicoInasistencia);
          
        justificacion.Justificar("");
    }
    
}
