
package empleado;

import modelo.*;
import excepciones.AsistenciaIncompletaException;
import dao.JornadaDAO;
import excepciones.JornadaCerradaException;
import excepciones.SinIniciarJornadaException;
import java.util.*;
import org.joda.time.DateTime;
import org.junit.*;
import static org.mockito.Mockito.*;

public class AnalizadorDeJornadaTest {
    
    private Jornada jornada;
    private JornadaDAO servicio;
    private List<Jornada> listado;
    private AnalizadorDeJornada analizador;
    
    public AnalizadorDeJornadaTest() {
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
        listado = new ArrayList<>();
    }
    
    @After
    public void tearDown() {
    
    }
    
    @Test
    public void cerrarJornadasDeFechasAnterioresALaActual() throws 
            AsistenciaIncompletaException, JornadaCerradaException, SinIniciarJornadaException {
         
         when(jornada.estaEnCurso()).thenReturn(true);
         when(jornada.getFecha()).thenReturn(new DateTime("2017-11-01"));
         listado.add(jornada);
         DateTime fechaDeAnalisis = new DateTime("2017-11-05");
         analizador = new AnalizadorDeJornada(listado, fechaDeAnalisis);
         analizador.analizar();
         
         verify(jornada).estaEnCurso();
         verify(jornada).cerrar();
        
    }

   
}
